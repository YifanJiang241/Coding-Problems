package Whatnot;

//
//计算给定进入和离开时间的房间内的人数：
//        这个问题要求你跟踪一段时间内人们进出一个房间的情况。给定两个数组，一个代表人们进入房间的时间，另一个代表离开房间的时间，你需要计算任意给定时间内房间里的人数。常见的解决方法是使用扫描线算法，通过排序进入和离开事件来高效地计算人数。

public class RoomOccupancy {

    /**
     * Calculates the number of people in the room at a given time.
     *
     * @param enters an array of times when people enter the room.
     * @param exits an array of times when people exit the room.
     * @param specificTime the time at which the number of people in the room is to be calculated.
     * @return the number of people in the room at the specific time.
     */
    public static int countPeopleInRoom(int[] enters, int[] exits, int specificTime) {
        int numberOfPeople = 0;

        // Count how many have entered before or at the specific time
        for (int enter : enters) {
            if (enter <= specificTime) {
                numberOfPeople++;
            }
        }

        // Subtract the number of people who have left before or at the specific time
        for (int exit : exits) {
            if (exit < specificTime) {
                numberOfPeople--;
            }
        }

        return numberOfPeople;
    }

    public static void main(String[] args) {
        int[] enters = {1, 2, 5, 7}; // Times when people enter the room
        int[] exits = {4, 6, 8, 9}; // Times when people leave the room
        int specificTime = 6; // The time at which to calculate the number of people in the room

        int peopleInRoom = countPeopleInRoom(enters, exits, specificTime);
        System.out.println("Number of people in the room at time " + specificTime + ": " + peopleInRoom);
    }
}
