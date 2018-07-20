package com.company.jsonParser;

import com.company.nodeItem.Impl.Item;
import com.company.nodeItem.Impl.LeafImpl;
import com.company.nodeItem.Impl.NodeImpl;
import com.company.Node.enums.ItemType;
import com.company.Node.enums.LimitType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static Item parse(String jsonString) throws InstructionParseException {
        try {
            JSONObject object = (JSONObject) JSONValue.parse(jsonString);
            switch (getType(object.get("type"))) {
                case NODE: {
                    return new NodeImpl(
                            getLimitType(object.get("limitType")),
                            getLimitValue(object.get("limitValue")),
                            getItemList((JSONArray) object.get("items"))
                    );
                }
                case LEAF: {
                    return new LeafImpl(
                            getLimitType(object.get("limitType")),
                            getLimitValue(object.get("limitValue")),
                            getData(object.get("data"))
                    );
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

    private static List<Item> getItemList(JSONArray array) throws InstructionParseException {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            items.add(parse(array.get(i).toString()));
        }
        return items;
    }

    private static String getData(Object data) {
        return data.toString();
    }
}
