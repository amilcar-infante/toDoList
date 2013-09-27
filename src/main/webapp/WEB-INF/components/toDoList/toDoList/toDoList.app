<aura:application preload="toDoList" template="toDoList:template">
	<aura:attribute name="filter" type="String" default=""/>
	
	<ui:outputText class="todo-list-title" value="Aura Todo List"/>
	<toDoList:toDoListCmp filter="{!v.filter}"/>
</aura:application>
