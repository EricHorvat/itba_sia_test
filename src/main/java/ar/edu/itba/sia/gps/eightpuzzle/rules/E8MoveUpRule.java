package ar.edu.itba.sia.gps.eightpuzzle.rules;

import ar.edu.itba.sia.gps.eightpuzzle.E8State;
import ar.edu.itba.sia.gps.eightpuzzle.Pair;
import ar.edu.itba.sia.gps.api.State;
import ar.edu.itba.sia.gps.exception.NotAppliableException;

import java.util.Optional;

/**
 * Created by eric on 15/03/17.
 */
public class E8MoveUpRule extends E8MoveRule {

    @Override
    public String getName() {
        return "Move Up";
    }

    @Override
    public Optional<State> evalRule(State state) {
        E8State e8state = (E8State) state;
        Pair blank = e8state.getBlank();
        if(blank.getX() == 0)
            return Optional.empty();
        Pair destiny = new Pair(blank.getX(), blank.getY()-1);
        return super.evalRule(state,destiny);
    }
}
