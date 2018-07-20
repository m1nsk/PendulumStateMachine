package com.company;

import com.company.jsonParser.InstructionParseException;
import com.company.jsonParser.Parser;
import com.company.jsonParser.ParserNew;
import com.company.nodeItem.Impl.Item;
import com.company.nodeItem.Impl.LeafImpl;
import com.company.nodeItem.Impl.NodeImpl;
import com.company.nodeItem.ItemType;
import com.company.nodeItem.Leaf;
import com.company.nodeItem.LimitType;
import com.company.nodeItem.Node;
import com.company.stateMachine.PendulumSwingState;
import com.company.stateMachine.StateMachine;
import com.company.stateMachine.StateMachineNew;
import com.company.stateMachine.iterItem.WrongTypeException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String jsonString = "{" +
            "\"type\":\"node\"" +
            "\"limitType\":\"count\"" +
            "\"limitValue\":\"1\"" +
            "\"items\":[" +
                    "{" +
                    "\"type\":\"leaf\"" +
                    "\"limitType\":\"count\"" +
                    "\"limitValue\":\"1\"" +
                    "\"data\":\"a\"" +
                    "}" +
                    "{" +
                    "\"type\":\"leaf\"" +
                    "\"limitType\":\"count\"" +
                    "\"limitValue\":\"1\"" +
                    "\"data\":\"b\"" +
                    "}" +
                    "{" +
                        "\"type\":\"node\"" +
                        "\"limitType\":\"count\"" +
                        "\"limitValue\":\"3\"" +
                        "\"items\":[" +
                                "{" +
                                "\"type\":\"leaf\"" +
                                "\"limitType\":\"count\"" +
                                "\"limitValue\":\"2\"" +
                                "\"data\":\"1\"" +
                                "}" +
                                "{" +
                                "\"type\":\"leaf\"" +
                                "\"limitType\":\"count\"" +
                                "\"limitValue\":\"2\"" +
                                "\"data\":\"2\"" +
                                "}" +
                        "]" +
                    "}" +
                    "{" +
                    "\"type\":\"leaf\"" +
                    "\"limitType\":\"count\"" +
                    "\"limitValue\":\"1\"" +
                    "\"data\":\"3\"" +
                    "}" +
                    "{" +
                    "\"type\":\"leaf\"" +
                    "\"limitType\":\"count\"" +
                    "\"limitValue\":\"2\"" +
                    "\"data\":\"4\"" +
                    "}" +
            "]" +
            "}";

    public static void main(String[] args) throws InstructionParseException, WrongTypeException, InterruptedException {
//        List<Item> items = new ArrayList<>();
//        items.add(new LeafImpl(LimitType.COUNT, 1, "1"));
//        items.add(new LeafImpl(LimitType.COUNT, 1, "2"));
//        List<Item> items1 = new ArrayList<>();
//        items1.add(new LeafImpl(LimitType.COUNT, 1, "3"));
//        items1.add(new LeafImpl(LimitType.COUNT, 1, "4"));
//        items.add(new NodeImpl(LimitType.COUNT, 2, items1));
//        items.add(new LeafImpl(LimitType.COUNT, 1, "5"));
//        items.add(new LeafImpl(LimitType.COUNT, 1, "6"));

//        Item node = new NodeImpl(LimitType.COUNT, 2, items);
        StateMachineNew sm = new StateMachineNew();
//        sm.setInstructions(Parser.parse(jsonString));
        com.company.Node.Item node = ParserNew.parse(jsonString, new com.company.Node.NodeImpl(LimitType.COUNT, 0));
        sm.setInstructions(node);
        List<PendulumSwingState> swingStates = new ArrayList<>();
        swingStates.add(PendulumSwingState.FREE);
        swingStates.add(PendulumSwingState.LEFT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.FREE);
        swingStates.add(PendulumSwingState.ZERO);
        swingStates.add(PendulumSwingState.FREE);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.FREE);
        swingStates.add(PendulumSwingState.LEFT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.FREE);
        swingStates.add(PendulumSwingState.ZERO);
        swingStates.add(PendulumSwingState.FREE);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        swingStates.add(PendulumSwingState.RIGHT);
        for (int i = 0; i < swingStates.size(); i++) {
            sm.newState(swingStates.get(i));
            Thread.sleep(100);
        }
//        iterateOverTree(node);
//        parseInstruction(jsonString);
    }

    private static void iterateOverTree(Item item){
        if(item.isNode().equals(ItemType.NODE)) {
            Node node = (Node)item;
            for (int i = 0; i < node.getLen(); i++) {
                iterateOverTree(node.getItem(i));
            }
        }
        else {
            Leaf<String> leaf = (Leaf)item;
            System.out.println(leaf.getData());
        }
    }

    private static void parseInstruction(String str) {

    }
}
