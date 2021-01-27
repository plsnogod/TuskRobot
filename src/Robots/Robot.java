package Robots;


public class Robot {

    static Direction direction = Direction.UP; // определяем взгляд робота
    static int x = 45;
    static int y = 12;

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        if (direction == Direction.DOWN) {
            direction = Direction.RIGHT;
        } else if (direction == Direction.RIGHT) {
            direction = Direction.UP;
        } else if (direction == Direction.UP) {
            direction = Direction.LEFT;
        } else if (direction == Direction.LEFT) {
            direction = Direction.DOWN;
        }
    }

    public void turnRight() {
        if (direction == Direction.DOWN) {
            direction = Direction.LEFT;
        } else if (direction == Direction.RIGHT) {
            direction = Direction.DOWN;
        } else if (direction == Direction.UP) {
            direction = Direction.RIGHT;
        } else if (direction == Direction.LEFT) {
            direction = Direction.UP;
        }
    }

    public void stepForward() {
        if (direction == Direction.DOWN) {
            y--;
        } else if (direction == Direction.RIGHT) {
            x++;
        } else if (direction == Direction.UP) {
            y++;
        } else if (direction == Direction.LEFT) {
            x--;
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        int directX = robot.getX();
        int directY = robot.getY();
        if (directY >= toY) {
            while (robot.getDirection() != Direction.DOWN) {
                robot.turnLeft();
            }
            while (directY != toY) {
                robot.stepForward();
                directY--;
            }
        } else {
            while (robot.getDirection() != Direction.UP) {
                robot.turnRight();
            }
            while (directY != toY) {
                robot.stepForward();
                directY++;
            }
        }
        if (directX >= toX) {
            while (robot.getDirection() != Direction.LEFT) {
                robot.turnLeft();
            }
            while (directX != toX) {
                robot.stepForward();
                directX--;
            }
        } else {
            while (robot.getDirection() != Direction.RIGHT) {
                robot.turnRight();
            }
            while (directX != toX) {
                robot.stepForward();
                directX++;
            }
        }
    }
}
enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

class Main {
    public static void main(String[] args) {
        Robot robot = new Robot();
        System.out.println("Изначальное положение взгляда "+robot.getDirection());
        System.out.println("Изначальное положение робота по оси Х "+robot.getX());
        System.out.println("Изначальное положение робота по оси Y "+robot.getY());

        Robot.moveRobot(robot, 32, 12); //Указываем куда переместить робота

        System.out.println("Направление взгляда после ввода новых позиций "+ robot.getDirection());
        System.out.println("Координата куда мы поставили робота после ввода новых указаний по оси Х "+robot.getX());
        System.out.println("Координата куда мы поставили робота после ввода новых указаний по оси Y "+robot.getY());
    }
}
