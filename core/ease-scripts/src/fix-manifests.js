bot = new org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot();

// open uml file
print("Open package explorer");
explorerView = bot.viewByTitle("Package Explorer");
explorerView.show();
explorer = explorerView.bot().tree()

fixManifest("org.osate.aadl2");
fixManifest("org.osate.aadl2.edit");

print("done");

function fixManifest(plugin) {
	print("Fix manifest for " + plugin);
	
	node = findTreeItem(explorer.getAllItems(), "osate2-core")
	waitExpand(node);
	node = findTreeItem(node.getItems(), plugin);
	waitExpand(node);
	node = findTreeItem(node.getItems(), "META-INF");
	waitExpand(node);
	node = findTreeItem(node.getItems(), "MANIFEST.MF");
	bot.sleep(250);
	node.contextMenu("Open").click();
	bot.sleep(500);
	
	print("Remove line");
	
	edit = bot.menu("Edit");
	edit.menu("Find/Replace...").click();
	
	shell = bot.shell("Find/Replace");
	dialog = shell.bot();
	dialog.comboBoxWithLabel("Find:").setText(" " + plugin + ";visibility:=reexport,\\n");
	dialog.comboBoxWithLabel("Replace with:").setText("");
	// radio button doesn't work!
	//dialog.radioWithLabelInGroup("Forward", "Direction").click();
	//dialog.radioWithLabel("All").click();
	dialog.checkBox("Case sensitive").select();
	dialog.checkBox("Wrap search").deselect();
	dialog.checkBox("Regular expressions").select();
	
	dialog.button("Find").click();
	clickOpt(dialog.button("Replace"));
	dialog.button("Close").click();
	bot.sleep(250);
	
	edit = bot.menu("File");
	clickOpt(edit.menu("Save"));

	editor = bot.editorByTitle(plugin);
	editor.close();
	bot.sleep(250);
}

function findTreeItem(items, match) {
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

function clickOpt(widget) {
	bot.sleep(250);
	if (widget.isEnabled()) {
		widget.click();
	}
}