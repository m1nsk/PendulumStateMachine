package com.company;

import com.company.Node.impl.Item;
import com.company.jsonParser.InstructionParseException;
import com.company.jsonParser.ParserNew;
import com.company.stateMachine.PendulumSwingState;
import com.company.stateMachine.StateMachineNew;
import com.company.Node.exceptions.WrongTypeException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String jsonString = "{" +
            "\"type\":\"node\"" +
            "\"limitType\":\"count\"" +
            "\"limitValue\":\"2\"" +
            "\"items\":[" +
                    "{" +
                    "\"type\":\"leaf\"" +
                    "\"limitType\":\"count\"" +
                    "\"limitValue\":\"2\"" +
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
                        "\"limitValue\":\"2\"" +
                        "\"items\":[" +
                                "{" +
                                "\"type\":\"leaf\"" +
                                "\"limitType\":\"count\"" +
                                "\"limitValue\":\"1\"" +
                                "\"data\":\"1\"" +
                                "}" +
                                "{" +
                                "\"type\":\"leaf\"" +
                                "\"limitType\":\"count\"" +
                                "\"limitValue\":\"1\"" +
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
                    "\"limitValue\":\"1\"" +
                    "\"data\":\"4\"" +
                    "}" +
            "]" +
            "}";

    public static void main(String[] args) throws InstructionParseException, WrongTypeException, InterruptedException {

        StateMachineNew sm = new StateMachineNew();
        Item node = ParserNew.parse(jsonString, null);
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
            sm.newState(isTurn(swingStates.get(i)));
            Thread.sleep(10);
        }
    }

    private static boolean isTurn(PendulumSwingState state) {
        return state == PendulumSwingState.LEFT || state == PendulumSwingState.RIGHT;
    }
}
