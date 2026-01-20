/*
* Written By Joshua Veal and Alexander Jensen
*/
public class CodeDoorFinder {
    public static void main(String[] args) throws Exception {

    }

    /*
     * Takes a parameter of a code door wall, finds the the door, then returns where
     * it is.
     */
    public static void findDoor(CodeDoorWall wall) {
        boolean rightDoor = false;
        boolean isLeft = false;
        int increment = 1;

        if (wall.checkCodeWord() == true) {
            rightDoor = true;
        }

        // While loop until we find the right door
        while (rightDoor == false) {
            // start for loop for the amount of times we need to increment
            for (int i = 0; i < increment; i++) {
                // We are left of center moving right
                if (isLeft == true) {
                    wall.stepRight();
                    if (wall.checkCodeWord() == true) {
                        rightDoor = true;
                    }
                }
                // We are right of center moving left
                else {
                    wall.stepLeft();
                    if (wall.checkCodeWord() == true) {
                        rightDoor = true;
                    }
                }
            }
            // Checks if we WERE left or right
            if (isLeft == false) {
                // If we were right, we are now left
                isLeft = true;
                for (int i = 0; i < increment; i++) {
                    wall.stepLeft();
                }
                increment *= 2;
            } else {
                // If we were left, we are now right
                isLeft = false;
                for (int i = 0; i < increment; i++) {
                    wall.stepRight();
                }
                increment *= 2;
            }
            // Check the position for if it is the right door, if so, break from while loop
            System.out.println(wall.getPosition());
            if (wall.checkCodeWord() == true) {
                break;
            }
        }

    }

    /**
     * Returns the authors' names.
     * 
     * @return Joshua Veal and Alexander Jensen
     */
    public static String getAuthors() {
        return "Joshua Veal and Alexander Jensen";
    }
}
// Best possible runtime is steps/distance = C, this is big theta of steps.
