package ru.s4m1d.notes.app.desktop.client.components;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ComponentAnalizerUtil {
    public static Map<Object, Action> getActionsFrom(JTextComponent textComponent){
        Map<Object, Action> result = new HashMap<>();
        Action[] actions = textComponent.getActions();
        for (int i=0; i<actions.length;i++){
            result.put(actions[i].getValue(Action.NAME), actions[i]);
        }
        return result;
    }
}