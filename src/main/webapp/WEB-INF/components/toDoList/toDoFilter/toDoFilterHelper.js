({
	getItemsLengthByFilter : function(cmp, filter) {
		var attributes = cmp.getAttributes();
		var items = attributes.getValue('items');
		var leftItemsLength = 0;
		var completedItemsLength = 0;
		for(var i = items.getLength()-1; i >= 0; i--) {
			if (!items.get(i).disabled) {
				if (!items.get(i).selected) {
					leftItemsLength++;
				} else {
					completedItemsLength++;
				}
			}
		};
		attributes.setValue('leftItemsLength', leftItemsLength);
		attributes.setValue('completedItemsLength', completedItemsLength);
	}
})