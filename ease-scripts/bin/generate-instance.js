bot = new org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot();

// open uml file
print("Open package explorer");
explorerView = bot.viewByTitle("Package Explorer");
explorerView.show();
explorer = explorerView.bot().tree()

// reload genmodel file
print("Reload generator model");
node = findTreeItem(explorer.getAllItems(), "osate2-core")
waitExpand(node);
node = findTreeItem(node.getItems(), "org.osate.aadl2");
waitExpand(node);
node = findTreeItem(node.getItems(), "model");
waitExpand(node);
node = findTreeItem(node.getItems(), "instance.genmodel");
node.contextMenu("Reload...").click();

reload = bot.shell("Reload");
reload.bot().button("Next >").click();
bot.sleep(500);
reload.bot().button("Next >").click();
bot.sleep(500);
reload.bot().button("Finish").click();

// generate all
print("Generate code");
editor = bot.editorByTitle("instance.genmodel");
editor.show();
editor.setFocus();
tree = editor.bot().tree();
root = tree.getTreeItem("Instance");
root.contextMenu("Generate All").click();

// wait until done
progress = bot.shell("Progress Information");
bot.waitUntil(org.eclipse.swtbot.swt.finder.waits.Conditions.shellCloses(progress), 2 * 60 * 1000);

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
