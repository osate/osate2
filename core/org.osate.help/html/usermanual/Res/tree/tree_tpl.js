/*
	Feel free to use your custom icons for the tree. Make sure they are all of the same size.
	If you don't use some keys you can just remove them from this config
*/

var TREE_TPL = {

	// general
	'target':'_self',	// name of the frame links will be opened in
						// other possible values are:
						// _blank, _parent, _search, _self and _top

	// icons - root	
	'icon_48':'', // root icon normal
	'icon_52':'', // root icon selected
	'icon_56':'', // root icon opened
	'icon_60':'', // root icon selected opened

	// icons - node	
	'icon_16':'', // node icon normal
	'icon_20':'', // node icon selected
	'icon_24':'', // node icon opened
	'icon_28':'', // node icon selected opened
	'icon_80':'', // normaled node icon hover

	// icons - leaf
	'icon_0':'', // leaf icon normal
	'icon_4':'', // leaf icon selected
	'icon_64':'', // leaf icon hover

	// icons - junctions	
	'icon_2':'', // junction for leaf
	'icon_3':'', // junction for last leaf
	'icon_18':'Res/tree/plus.gif', // junction for closed node
	'icon_19':'Res/tree/plus.gif', // junctioin for last closed node
	'icon_26':'Res/tree/minus.gif', // junction for opened node
	'icon_27':'Res/tree/minus.gif', // junctioin for last opended node

	// icons - misc
	'icon_e':'Res/tree/empty.gif', // empty image
	'icon_l':'Res/tree/empty.gif', // vertical line
	
	// styles - root
	'style_48':'mout', // normal root caption style
	'style_52':'mout', // selected root catption style
	'style_56':'mout', // opened root catption style
	'style_60':'mout', // selected opened root catption style
	'style_112':'mover', // normaled normal root caption style
	'style_116':'mover', // normaled selected root catption style
	'style_120':'mover', // normaled opened root catption style
	'style_124':'mover', // normaled selected opened root catption style
	
	// styles - node
	'style_16':'mout', // normal node caption style
	'style_20':'mout', // selected node catption style
	'style_24':'mout', // opened node catption style
	'style_28':'mout', // selected opened node catption style
	'style_80':'mover', // normaled normal node caption style
	'style_84':'mover', // normaled selected node catption style
	'style_88':'mover', // normaled opened node catption style
	'style_92':'mover', // normaled selected opened node catption style

	// styles - leaf
	'style_0':'mout', // normal leaf caption style
	'style_4':'mout', // selected leaf catption style
	'style_64':'mover', // normaled normal leaf caption style
	'style_68':'mover', // normaled selected leaf catption style
	
	// styles - misc
	'icon':'style_icons', // Class for tree icons images; JS added 2003-07-25

	// event handlers - item
	'onItemOpen':'open_handler',// on item open event handler
	'onItemClose':'close_handler'// on item close event handler
	// make sure there is no comma after the last key-value pair
};

function open_handler (o_item) {
   onItemOpenHandler (o_item);
	return true;
}
function close_handler (o_item) {
	//alert("This is node close event handler.\nThe caption of the item being closed is: '"+o_item.a_config[0]+"'");
	return true;
}

function onItemOpenHandler (o_item) {
	// get current block
	var a_curblock = o_item.o_parent.a_children;
	// close all nodes except current
	for (var i = 0; i < a_curblock.length; i++)
		if (a_curblock[i].n_state & 48 && a_curblock[i] != o_item)
			a_curblock[i].open(true);
	return false;
}
