package com.company.jsonParser;

import com.company.Node.impl.LeafImpl;
import com.company.Node.impl.Item;
import com.company.Node.impl.NodeImpl;
import com.company.Node.enums.ItemType;
import com.company.Node.enums.LimitType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.ArrayList;
import java.util.List;

public class ParserNew {
    public static Item parse(String jsonString, Item parent) throws InstructionParseException {
        try {
            JSONObject object = (JSONObject) JSONValue.parse(jsonString);
            switch (getType(object.get("type"))) {
                case NODE: {
                    NodeImpl item = new NodeImpl(
                            getLimitType(object.get("limitType")),
                            getLimitValue(object.get("limitValue"))
                    );
                    item.setDeepNext(getItemList((JSONArray) object.get("items"), item));
                    item.setNext(parent);
                    return item;
                }
                case LEAF: {
                    LeafImpl leaf = new LeafImpl(
                            getLimitType(object.get("limitType")),
                            getLimitValue(object.get("limitValue")),
                            getData(object.get("data")),
                            parent
                    );
                    return leaf;
                }
            }
        } catch (Exception e) {
            throw new InstructionParseException(e);
        }
        return null;
    }

    private static ItemType getType(Object type) throws InstructionParseException {
        switch (type.toString()) {
            case "node":
                return ItemType.NODE;
            case "leaf":
                return ItemType.LEAF;
            default:
                throw new InstructionParseException();
        }
    }

    private static LimitType getLimitType(Object type) throws InstructionParseException {
        switch (type.toString()) {
            case "time":
                return LimitType.TIME;
            case "count":
                return LimitType.COUNT;
            default:
                throw new InstructionParseException();
        }
    }

    private static int getLimitValue(Object value) throws InstructionParseException {
        try {
            return Integer.parseInt(value.toString());
        } catch (NumberFormatException e) {
            throw new InstructionParseException(e);
        }
    }

    private static Item getItemList(JSONArray array, Item parent) throws InstructionParseException {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            items.add(parse(array.get(i).toString(), parent));
        }
        for (int i = 0; i < array.size(); i++) {
            items.get(i).setNext(i == array.size() - 1 ? parent : items.get(i + 1));
        }
        return items.get(0);
    }

    private static String getData(Object data) {
        return data.toString();
    }
}
