package entity;

import contant.DirectionConstants;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Axis {

    private int xAxis, yAxis = 0;
    private int currentMovingDirection = DirectionConstants.North;
}
