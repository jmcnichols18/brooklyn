package com.company.brooklyn.web.reoproperties;

import com.company.brooklyn.entity.REOProperties;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.gui.components.actions.EditAction;
import com.haulmont.cuba.gui.components.actions.RemoveAction;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.DataSupplier;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public class REOPropertiesBrowse extends AbstractLookup {

    /**
     * The {@link CollectionDatasource} instance that loads a list of {@link REOProperties} records
     * to be displayed in {@link REOPropertiesBrowse#rEOPropertiesesTable} on the left
     */
    @Inject
    private CollectionDatasource<REOProperties, Integer> rEOPropertiesesDs;

    /**
     * The {@link Datasource} instance that contains an instance of the selected entity
     * in {@link REOPropertiesBrowse#rEOPropertiesesDs}
     * <p/> Containing instance is loaded in {@link CollectionDatasource#addItemChangeListener}
     * with the view, specified in the XML screen descriptor.
     * The listener is set in the {@link REOPropertiesBrowse#init(Map)} method
     */
    @Inject
    private Datasource<REOProperties> rEOPropertiesDs;

    /**
     * The {@link Table} instance, containing a list of {@link REOProperties} records,
     * loaded via {@link REOPropertiesBrowse#rEOPropertiesesDs}
     */
    @Inject
    private Table<REOProperties> rEOPropertiesesTable;

    /**
     * The {@link BoxLayout} instance that contains components on the left side
     * of {@link SplitPanel}
     */
    @Inject
    private BoxLayout lookupBox;

    /**
     * The {@link BoxLayout} instance that contains buttons to invoke Save or Cancel actions in edit mode
     */
    @Inject
    private BoxLayout actionsPane;

    /**
     * The {@link FieldGroup} instance that is linked to {@link REOPropertiesBrowse#rEOPropertiesDs}
     * and shows fields of the selected {@link REOProperties} record
     */
    @Inject
    private FieldGroup fieldGroup;

    /**
     * The {@link RemoveAction} instance, related to {@link REOPropertiesBrowse#rEOPropertiesesTable}
     */
    @Named("rEOPropertiesesTable.remove")
    private RemoveAction rEOPropertiesesTableRemove;

    @Inject
    private DataSupplier dataSupplier;

    /**
     * {@link Boolean} value, indicating if a new instance of {@link REOProperties} is being created
     */
    private boolean creating;

    @Override
    public void init(Map<String, Object> params) {

        /**
         * Adding {@link com.haulmont.cuba.gui.data.Datasource.ItemChangeListener} to {@link rEOPropertiesesDs}
         * The listener reloads the selected record with the specified view and sets it to {@link rEOPropertiesDs}
         */
        rEOPropertiesesDs.addItemChangeListener(e -> {
            if (e.getItem() != null) {
                REOProperties reloadedItem = dataSupplier.reload(e.getDs().getItem(), rEOPropertiesDs.getView());
                rEOPropertiesDs.setItem(reloadedItem);
            }
        });

        /**
         * Adding {@link CreateAction} to {@link rEOPropertiesesTable}
         * The listener removes selection in {@link rEOPropertiesesTable}, sets a newly created item to {@link rEOPropertiesDs}
         * and enables controls for record editing
         */
        rEOPropertiesesTable.addAction(new CreateAction(rEOPropertiesesTable) {
            @Override
            protected void internalOpenEditor(CollectionDatasource datasource, Entity newItem, Datasource parentDs, Map<String, Object> params) {
                rEOPropertiesesTable.setSelected(Collections.emptyList());
                rEOPropertiesDs.setItem((REOProperties) newItem);
                enableEditControls(true);
            }
        });

        /**
         * Adding {@link EditAction} to {@link rEOPropertiesesTable}
         * The listener enables controls for record editing
         */
        rEOPropertiesesTable.addAction(new EditAction(rEOPropertiesesTable) {
            @Override
            protected void internalOpenEditor(CollectionDatasource datasource, Entity existingItem, Datasource parentDs, Map<String, Object> params) {
                if (rEOPropertiesesTable.getSelected().size() == 1) {
                    enableEditControls(false);
                }
            }
        });

        /**
         * Setting {@link RemoveAction#afterRemoveHandler} for {@link rEOPropertiesesTableRemove}
         * to reset record, contained in {@link rEOPropertiesDs}
         */
        rEOPropertiesesTableRemove.setAfterRemoveHandler(removedItems -> rEOPropertiesDs.setItem(null));

        disableEditControls();
    }

    /**
     * Method that is invoked by clicking Save button after editing an existing or creating a new record
     */
    public void save() {
        getDsContext().commit();

        REOProperties editedItem = rEOPropertiesDs.getItem();
        if (creating) {
            rEOPropertiesesDs.includeItem(editedItem);
        } else {
            rEOPropertiesesDs.updateItem(editedItem);
        }
        rEOPropertiesesTable.setSelected(editedItem);

        disableEditControls();
    }

    /**
     * Method that is invoked by clicking Save button after editing an existing or creating a new record
     */
    public void cancel() {
        REOProperties selectedItem = rEOPropertiesesDs.getItem();
        if (selectedItem != null) {
            REOProperties reloadedItem = dataSupplier.reload(selectedItem, rEOPropertiesDs.getView());
            rEOPropertiesesDs.setItem(reloadedItem);
        } else {
            rEOPropertiesDs.setItem(null);
        }

        disableEditControls();
    }

    /**
     * Enabling controls for record editing
     * @param creating indicates if a new instance of {@link REOProperties} is being created
     */
    private void enableEditControls(boolean creating) {
        this.creating = creating;
        initEditComponents(true);
        fieldGroup.requestFocus();
    }

    /**
     * Disabling editing controls
     */
    private void disableEditControls() {
        initEditComponents(false);
        rEOPropertiesesTable.requestFocus();
    }

    /**
     * Initiating edit controls, depending on if they should be enabled/disabled
     * @param enabled if true - enables editing controls and disables controls on the left side of the splitter
     *                if false - visa versa
     */
    private void initEditComponents(boolean enabled) {
        fieldGroup.setEditable(enabled);
        actionsPane.setVisible(enabled);
        lookupBox.setEnabled(!enabled);
    }
}