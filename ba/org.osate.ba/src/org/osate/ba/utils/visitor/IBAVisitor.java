package org.osate.ba.utils.visitor;

import org.osate.ba.aadlba.*;

public interface IBAVisitor {
	// Entry point
	void visit(BehaviorAnnex ba);

	void visit(ActualPortHolder aph);

	void visit(AssignmentAction aa);

	void visit(Any a);

	void visit(BasicAction ba);

	void visit(BasicPropertyHolder bph);

	void visit(BehaviorAction ba);

	void visit(BehaviorActionBlock bab);

	void visit(BehaviorActionCollection bac);

	void visit(BehaviorActions ba);

	void visit(BehaviorActionSequence bas);

	void visit(BehaviorActionSet bas);

	void visit(BehaviorBooleanLiteral bbl);

	void visit(BehaviorCondition bc);

	void visit(BehaviorElement be);

	void visit(BehaviorIntegerLiteral bil);

	void visit(BehaviorNamedElement bne);

	void visit(BehaviorPropertyConstant bpc);

	void visit(BehaviorRealLiteral brl);

	void visit(BehaviorState bs);

	void visit(BehaviorStringLiteral bsl);

	void visit(BehaviorTime bt);

	void visit(BehaviorTransition bt);

	void visit(BehaviorVariable bv);

	void visit(BehaviorVariableHolder bvh);

	void visit(CalledSubprogramHolder csh);

	void visit(ClassifierFeatureHolder cfh);

	void visit(ClassifierFeaturePropertyReference cfpr);

	void visit(ClassifierPropertyReference cpr);

	void visit(CommunicationAction ca);

	void visit(CompletionRelativeTimeout crto);

	void visit(CondStatement cs);

	void visit(DataAccessHolder dah);

	void visit(DataAccessPrototypeHolder daph);

	void visit(DataComponentReference dcr);

	void visit(DataHolder dh);

	void visit(DataPortHolder dph);

	void visit(DataSubcomponentHolder dsh);

	void visit(DispatchCondition dc);

	void visit(DispatchConjunction dc);

	void visit(DispatchRelativeTimeout drt);

	void visit(DispatchTrigger dt);

	void visit(DispatchTriggerCondition dtc);

	void visit(DispatchTriggerConditionStop dtcs);

	void visit(DispatchTriggerLogicalExpression dtle);

	void visit(ElementHolder eh);

	void visit(ElementValues ev);

	void visit(ElseStatement es);

	void visit(EnumLiteralHolder elh);

	void visit(EventDataPortHolder edph);

	/**
	 * @since 9.0
	 */
	void visit(EventDataSourceHolder edsh);

	/**
	 * @since 9.0
	 */
	void visit(EventPortHolder eph);

	/**
	 * @since 9.0
	 */
	void visit(EventSourceHolder esh);

	void visit(ExecuteCondition ec);

	void visit(ExecutionTimeoutCatch etc);

	void visit(Factor f);

	void visit(FeatureHolder fh);

	void visit(FeaturePrototypeHolder fph);

	void visit(ForOrForAllStatement fofas);

	void visit(GroupableElement ge);

	void visit(GroupHolder gh);

	void visit(GroupPrototypeHolder gph);

	void visit(IfStatement is);

	void visit(IndexableElement ie);

	void visit(IntegerRange ir);

	void visit(IntegerValue iv);

	/**
	 * @since 9.0
	 */
	void visit(IntegerValueConstant ivc);

	/**
	 * @since 9.0
	 */
	void visit(IntegerValueVariable ivv);

	/**
	 * @since 9.0
	 */
	void visit(InternalCondition ic);

	/**
	 * @since 9.0
	 */
	void visit(InternalPortHolder iph);

	/**
	 * @since 9.0
	 */
	void visit(InternalPortSendAction ipsa);

	void visit(IterativeVariable iv);

	void visit(IterativeVariableHolder ivh);

	void visit(Literal l);

	void visit(LockAction la);

	void visit(LoopStatement ls);

	void visit(LowerBound lb);

	void visit(NumericLiteral nl);

	void visit(Otherwise o);

	void visit(ParameterHolder ph);

	void visit(ParameterLabel pl);

	void visit(PortCountValue pcv);

	void visit(PortDequeueAction pda);

	/**
	 * @since 9.0
	 */
	void visit(PortDequeueValue pdv);

	void visit(PortFreezeAction pfa);

	/**
	 * @since 9.0
	 */
	void visit(PortFreshValue pfv);

	void visit(PortHolder ph);

	void visit(PortPrototypeHolder pph);

	void visit(PortSendAction psa);

	/**
	 * @since 9.0
	 */
	void visit(PortUpdatedValue puv);

	void visit(PropertyAssociationHolder pah);

	void visit(PropertyElementHolder peh);

	void visit(PropertyExpressionHolder peh);

	void visit(PropertyNameField pnf);

	void visit(PropertyNameHolder pnh);

	void visit(PropertyReference pr);

	void visit(PropertySetPropertyReference pspr);

	void visit(PropertyTypeHolder pth);

	void visit(PrototypeHolder ph);

	void visit(Relation r);

	void visit(SharedDataAction sda);

	void visit(SimpleExpression se);

	void visit(StructUnionElement sue);

	void visit(StructUnionElementHolder sueh);

	void visit(SubcomponentHolder sch);

	void visit(SubprogramAccessHolder sah);

	/**
	 * @since 9.0
	 */
	void visit(SubprogramCallAction sca);

	/**
	 * @since 9.0
	 */
	void visit(SubprogramHolder sh);

	void visit(SubprogramHolderProxy shp);

	/**
	 * @since 9.0
	 */
	void visit(SubprogramPrototypeHolder sph);

	void visit(SubprogramSubcomponentHolder ssh);

	void visit(Target t);

	void visit(Term t);

	void visit(TimedAction ta);

	/**
	 * @since 9.0
	 */
	void visit(TimeoutResetPort trp);

	void visit(UnlockAction ua);

	void visit(UpperBound ub);

	void visit(Value v);

	void visit(ValueConstant vc);

	void visit(ValueExpression ve);

	void visit(ValueVariable vv);

	void visit(WhileOrDoUntilStatement wodus);
}
