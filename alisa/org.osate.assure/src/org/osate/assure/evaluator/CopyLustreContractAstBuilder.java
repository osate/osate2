package org.osate.assure.evaluator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;

import jkind.lustre.BinaryExpr;
import jkind.lustre.BinaryOp;
import jkind.lustre.BoolExpr;
import jkind.lustre.CondactExpr;
import jkind.lustre.Contract;
import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.NamedType;
import jkind.lustre.Node;
import jkind.lustre.NodeCallExpr;
import jkind.lustre.Program;
import jkind.lustre.RecordType;
import jkind.lustre.TupleExpr;
import jkind.lustre.Type;
import jkind.lustre.TypeDef;
import jkind.lustre.VarDecl;

import com.rockwellcollins.atc.agree.agree.AssumeStatement;
import com.rockwellcollins.atc.agree.agree.EqStatement;
import com.rockwellcollins.atc.agree.agree.LemmaStatement;
import com.rockwellcollins.atc.agree.agree.PropertyStatement;
import com.rockwellcollins.atc.agree.analysis.AgreeException;
import com.rockwellcollins.atc.agree.analysis.AgreeUtils;
import com.rockwellcollins.atc.agree.analysis.ast.AgreeASTBuilder;
import com.rockwellcollins.atc.agree.analysis.ast.AgreeNode;
import com.rockwellcollins.atc.agree.analysis.ast.AgreeProgram;
import com.rockwellcollins.atc.agree.analysis.ast.AgreeStatement;
import com.rockwellcollins.atc.agree.analysis.ast.AgreeVar;
import com.rockwellcollins.atc.agree.analysis.ast.AgreeNode.TimingModel;

public class CopyLustreContractAstBuilder extends CopyLustreAstBuilder {

    public static Program getContractLustreProgram(AgreeProgram agreeProgram) {

        nodes = new ArrayList<>();
        List<TypeDef> types = new ArrayList<>();
        for (Type type : agreeProgram.globalTypes) {
            RecordType recType = (RecordType) type;
            types.add(new TypeDef(recType.id, type));
        }

        AgreeNode flatNode = flattenAgreeNodeKindContract(agreeProgram.topNode, "_TOP__");
        List<Expr> assertions = new ArrayList<>();
        List<VarDecl> locals = new ArrayList<>();
        List<VarDecl> inputs = new ArrayList<>();
        List<VarDecl> outputs = new ArrayList<>();
        List<Equation> equations = new ArrayList<>();
        List<String> properties = new ArrayList<>();
        List<Expr> requires = new ArrayList<>();
        List<Expr> ensures = new ArrayList<>();

        for (AgreeStatement assertion : flatNode.assertions) {
            assertions.add(assertion.expr);
        }

        for (AgreeStatement assumption : flatNode.assumptions) {
            requires.add(assumption.expr);
        }

        for (AgreeStatement guarantee : flatNode.lemmas) {
            ensures.add(guarantee.expr);
        }

        for (AgreeStatement guarantee : flatNode.guarantees) {
            ensures.add(guarantee.expr);
        }

        for (AgreeVar var : flatNode.inputs) {
            inputs.add(var);
        }

        for (AgreeVar var : flatNode.outputs) {
            outputs.add(var);
        }

        for (AgreeVar var : flatNode.outputs) {
            if (var.reference instanceof AssumeStatement || var.reference instanceof LemmaStatement) {
                throw new AgreeException("This shouldn't happen");
            }
        }

        Contract contract = new Contract("_TOP", requires, ensures);

        Node main = new Node("_TOP", inputs, outputs, locals, equations, properties, assertions, null,
                Optional.of(Collections.singletonList(contract)));
        nodes.addAll(agreeProgram.globalLustreNodes);
        nodes.add(main);
        Program program = new Program(types, null, nodes, main.id);

        return program;

    }

    protected static AgreeNode flattenAgreeNodeKindContract(AgreeNode agreeNode, String nodePrefix) {

        List<AgreeVar> inputs = new ArrayList<>();
        List<AgreeVar> outputs = new ArrayList<>();
        List<AgreeVar> locals = new ArrayList<>();
        List<AgreeStatement> assertions = new ArrayList<>();

        Expr someoneTicks = null;
        for (AgreeNode subAgreeNode : agreeNode.subNodes) {
            String prefix = subAgreeNode.id + AgreeASTBuilder.dotChar;
            Expr clockExpr = getClockExpr(agreeNode, subAgreeNode);

            if (someoneTicks == null) {
                someoneTicks = clockExpr;
            } else {
                someoneTicks = new BinaryExpr(someoneTicks, BinaryOp.OR, clockExpr);
            }

            AgreeNode flatNode = flattenAgreeNodeKindContract(subAgreeNode,
                    nodePrefix + subAgreeNode.id + AgreeASTBuilder.dotChar);

            Node lustreNode = addSubNodeLustre(agreeNode, nodePrefix, flatNode);

            addInputsAndOutputs(inputs, outputs, flatNode, lustreNode, prefix);

            addCondactCall(agreeNode, nodePrefix, inputs, assertions, flatNode, prefix, clockExpr,
                    lustreNode);

            // addClockHolds(agreeNode, assertions, flatNode, clockExpr, prefix,
            // lustreNode);

            addInitConstraint(agreeNode, outputs, assertions, flatNode, prefix, clockExpr, lustreNode);

        }

        if (agreeNode.timing == TimingModel.ASYNC) {
            if (someoneTicks == null) {
                throw new AgreeException("Somehow we generated a clock constraint without any clocks");
            }
            assertions.add(new AgreeStatement("someone ticks", someoneTicks, null));
        }

        addConnectionConstraints(agreeNode, assertions);

        // add any clock constraints
        assertions.addAll(agreeNode.assertions);
        assertions.add(new AgreeStatement("", agreeNode.clockConstraint, null));
        inputs.addAll(agreeNode.inputs);
        outputs.addAll(agreeNode.outputs);
        locals.addAll(agreeNode.locals);

        return new AgreeNode(agreeNode.id, inputs, outputs, locals, null, agreeNode.subNodes, assertions,
                agreeNode.assumptions, agreeNode.guarantees, agreeNode.lemmas, new BoolExpr(true),
                agreeNode.initialConstraint, agreeNode.clockVar, agreeNode.reference, null,
                agreeNode.compInst);
    }

    protected static Node addSubNodeLustre(AgreeNode agreeNode, String nodePrefix, AgreeNode flatNode) {

        Node lustreNode = getLustreNode(flatNode, nodePrefix);
        addToNodes(lustreNode);
        return lustreNode;
    }

    protected static Node getLustreNode(AgreeNode agreeNode, String nodePrefix) {

        List<VarDecl> inputs = new ArrayList<>();
        List<VarDecl> outputs = new ArrayList<>();
        List<VarDecl> locals = new ArrayList<>();
        List<Equation> equations = new ArrayList<>();
        List<Expr> assertions = new ArrayList<>();
        List<Expr> requires = new ArrayList<>();
        List<Expr> ensures = new ArrayList<>();

        for (AgreeStatement statement : agreeNode.assumptions) {
            requires.add(statement.expr);
        }

        for (AgreeStatement statement : agreeNode.lemmas) {
            ensures.add(statement.expr);
        }

        for (AgreeStatement statement : agreeNode.guarantees) {
            ensures.add(statement.expr);
        }

        for (AgreeStatement statement : agreeNode.assertions) {
            assertions.add(statement.expr);
            if(AgreeUtils.statementIsContractEqOrProperty(statement)){
                ensures.add(statement.expr);
            }
        }

        // gather the remaining inputs
        for (AgreeVar var : agreeNode.inputs) {
            inputs.add(var);
        }
        for (AgreeVar var : agreeNode.outputs) {
            outputs.add(var);
        }
        Contract contract = new Contract(nodePrefix + agreeNode.id, requires, ensures);
        return new Node(nodePrefix + agreeNode.id, inputs, outputs, locals, equations, null, assertions, null,
                Optional.of(Collections.singletonList(contract)));
    }

    protected static void addInputsAndOutputs(List<AgreeVar> inputs, List<AgreeVar> outputs,
            AgreeNode subAgreeNode, Node lustreNode, String prefix) {
        for (AgreeVar var : subAgreeNode.inputs) {
            AgreeVar input = new AgreeVar(prefix + var.id, var.type, var.reference, var.compInst);
            inputs.add(input);
        }

        for (AgreeVar var : subAgreeNode.outputs) {
            AgreeVar output = new AgreeVar(prefix + var.id, var.type, var.reference, var.compInst);
            outputs.add(output);
        }

        // right now we do not support local variables in our translation
        for (AgreeVar var : subAgreeNode.locals) {
            throw new AgreeException("What is an example of this?");
            // varCount++;
            // AgreeVar local = new AgreeVar(prefix+var.id, var.type,
            // var.reference, var.compInst);
            // outputs.add(local);
        }

        inputs.add(subAgreeNode.clockVar);

    }

    protected static void addCondactCall(AgreeNode agreeNode, String nodePrefix, List<AgreeVar> inputs,
            List<AgreeStatement> assertions, AgreeNode subAgreeNode, String prefix, Expr clockExpr,
            Node lustreNode) {
        List<Expr> inputIds = new ArrayList<>();
        List<Expr> initOutputsVals = new ArrayList<>();
        List<IdExpr> nodeOutputIds = new ArrayList<>();
        for (VarDecl var : lustreNode.inputs) {
            inputIds.add(new IdExpr(prefix + var.id));
        }

        for (VarDecl var : lustreNode.outputs) {
            AgreeVar outputVar = (AgreeVar) var;
            String dummyName = prefix + var.id + "__DUMMY";
            AgreeVar dummyVar = new AgreeVar(dummyName, outputVar.type, outputVar.reference, outputVar.compInst);
            
            if (!inputs.contains(dummyVar)) {
                inputs.add(dummyVar);
            }

            initOutputsVals.add(new IdExpr(dummyName));
            nodeOutputIds.add(new IdExpr(prefix + var.id));
        }

        if (agreeNode.timing == TimingModel.LATCHED) {
            addLatchedConstraints(nodePrefix, inputs, assertions, subAgreeNode, prefix, inputIds);
        }

        Expr condactExpr =
                new CondactExpr(clockExpr, new NodeCallExpr(lustreNode.id, inputIds), initOutputsVals);

        Expr condactOutput;
        if(nodeOutputIds.size() > 1){
            condactOutput = new TupleExpr(nodeOutputIds);
        }else{
            condactOutput = nodeOutputIds.get(0);
        }
        
        Expr condactCall = new BinaryExpr(condactOutput, BinaryOp.EQUAL, condactExpr);
        assertions.add(new AgreeStatement("", condactCall, null));
    }

}
