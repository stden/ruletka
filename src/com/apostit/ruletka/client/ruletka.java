package com.apostit.ruletka.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class ruletka implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        final ListBox dropBox = createListBox(Converter.getCountries());

        final Button button = new Button("Click me");
        final Label label = new Label();
        final Button sendButton = new Button("Send");

        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (label.getText().equals("")) {
                    //ruletkaService.App.getInstance().getMessage("Hello, World!", new MyAsyncCallback(label));
                } else {
                    label.setText("");
                }
                Converter converter = new Converter();
            }
        });

        // Assume that the host HTML has elements defined whose
        // IDs are "slot1", "slot2".  In a real app, you probably would not want
        // to hard-code IDs.  Instead, you could, for example, search for all
        // elements with a particular CSS class and replace them with widgets.
        //
        RootPanel slot1 = RootPanel.get("slot1");
        slot1.add(button);
        slot1.add(sendButton);
        slot1.add(createListBox(Converter.getKinds()));
        slot1.add(dropBox);
        slot1.add(createListBox(Converter.getSizes()));

        RootPanel.get("slot2").add(label);
    }

    /**
     * Создаём выпадающий список
     *
     * @param strings Записи
     * @return
     */
    private ListBox createListBox(String[] strings) {
        final ListBox listBox = new ListBox(false);
        for (String s : strings) {
            listBox.addItem(s);
        }
        return listBox;
    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }
}
