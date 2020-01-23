importPackage(org.eclipse.swtbot.eclipse.finder);
bot = new SWTWorkbenchBot();

// open uml file
print("Open UML file");
explorerView = bot.viewByTitle("Package Explorer");
explorerView.show();
explorer = explorerView.bot().tree()
node = findTreeItem(explorer.getAllItems(), "core")
waitExpand(node);
node = findTreeItem(node.getItems(), "org.osate.aadl2.metamodel");
waitExpand(node);
node = findTreeItem(node.getItems(), "Models");
waitExpand(node);
node = findTreeItem(node.getItems(), "AADL2.EMF.uml");
node.contextMenu("Open With").menu("UML Model Editor").click();

// select top package
print("Select model package");
editor = bot.editorByTitle("AADL2.EMF.uml");
editor.show();
editor.setFocus();
tree = editor.bot().tree();
root = tree.getTreeItem("platform:/resource/org.osate.aadl2.metamodel/Models/AADL2.EMF.uml");
waitExpand(root);
root.select("<<EPackage, Metamodel>> <Model> AADL2");

// package merge
print("Package merge");
umlMenu = bot.menu("UML Editor");
umlMenu.menu("Package").menu("Merge...").click();

shell = bot.shell("Merge Package 'AADL2 - AADL2.EMF.uml'");
shell.bot().button("OK").click();
bot.waitUntil(org.eclipse.swtbot.swt.finder.waits.Conditions.shellCloses(shell));
shell = bot.shell("Merge Package 'AADL2 - AADL2.EMF.uml'");
shell.bot().button("OK").click();
bot.waitUntil(org.eclipse.swtbot.swt.finder.waits.Conditions.shellCloses(shell));

// convert to metamodel
print("Convert to metamodel");
umlMenu.menu("Convert To").menu("Metamodel").click();
bot.sleep(1000);

// save as AADL.EMF.merged.uml
/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
print("Save merged model");
bot.menu("File").menu("Save As...").click();

save = bot.shell("Save As");
tree = save.bot().tree();
node = findTreeItem(tree.getAllItems(), "org.osate.aadl2.metamodel");
waitExpand(node);
subnode = findTreeItem(node.getItems(), "Models");
node.select(subnode.getText());
save.bot().textWithLabel("&File name:").setText("AADL2.EMF.merged.uml");
save.bot().button("OK").click();

// overwrite existing file
overwrite = bot.shell("Question");
overwrite.bot().button("Yes").click();

// close editor
editor.close();

//reload genmodel file
print("Reload generator model");
node = findTreeItem(explorer.getAllItems(), "core")
waitExpand(node);
node = findTreeItem(node.getItems(), "org.osate.aadl2");
waitExpand(node);
node = findTreeItem(node.getItems(), "model");
waitExpand(node);
node = findTreeItem(node.getItems(), "aadl2.genmodel");
node.contextMenu("Reload...").click();

reload = bot.shell("Reload");
reload.bot().button("Next >").click();
bot.sleep(1000);
reload.bot().button("Next >").click();
bot.sleep(500);
reload.bot().button("Finish").click();

// generate all
print("Generate code");
editor = bot.editorByTitle("aadl2.genmodel");
editor.show();
editor.setFocus();
tree = editor.bot().tree();
root = tree.getTreeItem("Aadl2");
root.contextMenu("Generate All").click();

//wait until done
progress = bot.shell("Progress Information");
bot.waitUntil(org.eclipse.swtbot.swt.finder.waits.Conditions.shellCloses(progress), 3 * 60 * 1000);

editor.close();
print("done");

function findTreeItem (items, match) {
	for (i = 0; i < items.length; i++) {
		if (items[i].getText().search("^" + match + "$|(^| )" + match + "($| )") >= 0) {
			return items[i];
		}
	}
	return null;
}

function waitExpand(item) {
	for (i = 0; i < 100; i ++) {
	    if (item.select().isExpanded())
	    	item.collapse();
	    item.expand();
	    bot.sleep(250);
	    if (item.getItems().length > 0)
	    	break;
	}
}
