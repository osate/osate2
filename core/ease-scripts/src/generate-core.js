importPackage(org.eclipse.swtbot.eclipse.finder);
bot = new SWTWorkbenchBot();

// open uml file
print("Open UML file");
explorerView = bot.viewByTitle("Package Explorer");
explorerView.show();
explorer = explorerView.bot().tree()
node = findTreeItem(explorer.getAllItems(), "osate2-core")
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
node = findTreeItem(explorer.getAllItems(), "osate2-core")
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
