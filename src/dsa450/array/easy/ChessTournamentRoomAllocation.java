package dsa450.array.easy;

import java.util.Arrays;

/*
Chess tournament is going to be organized in Ninjaland.
There will be C chess players going to attend the tournament.
All the players will be staying in a hotel.
The hotel has N free rooms available for the players, where one player will choose one room to live in.
The ith room is at position[i] in the hotel. All rooms are in distinct positions.

let say we have 3 players and 5 rooms available and the rooms are at positions:  1 2 3 4 6
Here the optimal allocation is in rooms 1 3 6 and the overall focus level is 2.

Sample Input 1 :
1
5 3
1 2 3 4 6
Sample Output 1 :
2
Sample Input 2 :
2
4 2
5 4 2 1
6 4
6 7 9 13 15 11
Sample Output 2 :
4
2
Explanation For Sample Output 2:
In test case 1,
we only have to allocate rooms to 2 players so we can assign rooms that are first and last which are 1 and 5, so our answer is 5 - 1 = 4.

In test case 2,
there is no way by which we can allocate rooms such that every player will have the 3 or more as its least distance to other players. So the answer is 2 and one possible allocation of rooms is as follows.
    Player1 = 6
    Player2 = 9
    Player3 = 11
    Player4 = 13

6, 7, 9, 11 13 15 -> 6 9 11 13
 */
public class ChessTournamentRoomAllocation {
    public static void main(String[] arg) {
        int[] arr = {6, 7, 9, 11, 13, 15};
        System.out.println(Arrays.toString(arr));
        System.out.println(chessTournament(arr, 4));
    }


    /*
    Approach - 2 (Using binary search)
    ---------------------------------------------------
    We need to try to place the players from mid array space then we will go to right if we can not fit within middle.

     */
    public static int chessTournament(int[] arr, int c) {
        int ans = 0, l = 0, h = arr.length - 1, n = arr.length;

        Arrays.sort(arr);

        while (l <= h) {
            int mid = (l + h) / 2;

            if (isPlaced(arr, n, c, mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return ans;
    }

    public static boolean isPlaced(int[] arr, int n, int c, int distance) {
        int totalPlaced = 1;
        int recentlyPlacedIndex = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[recentlyPlacedIndex] >= distance) {
                totalPlaced = totalPlaced + 1;
                recentlyPlacedIndex = i;
            }
        }

        return totalPlaced >= c;
    }

}
