// package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class MazeProblem {
    public static void main(String[] args) {
        System.out.println(mazeCount(3, 3));
        boolean[][] maze = { { true, true, true },
                { true, true, true },
                { true, true, true },
        };
        int[][] path = new int[3][3];
        mazePathandMatrix(maze, "",path, 0, 0,1);
    }

    static void mazePathandMatrix(boolean[][] maze, String p, int[][] path, int r, int c, int count) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = count;
            for (int[] i : path) {
                System.out.println(Arrays.toString(i));
            }
            System.out.println(p);
            return ;
        }
        ArrayList<String> ans = new ArrayList<>();
        if (!maze[r][c]) {
            return;
        }
        maze[r][c] = false; // Mark cell as False, and explore the path
        path[r][c] = count;
        if (r < maze.length - 1) {
            mazePathandMatrix(maze, p + "D", path, r + 1, c, count+1);
        }
        if (c < maze[0].length - 1) {
            mazePathandMatrix(maze, p + "R", path, r, c + 1, count+1);
        }
        if (r > 0) {
            mazePathandMatrix(maze, p + "U", path, r - 1, c, count+1);
        }
        if (c > 0) {
            mazePathandMatrix(maze, p + "L", path, r, c - 1, count+1);
        }
        // In this line, the function will be over
        maze[r][c] = true; // remark the cell as true, as it was previous
        path[r][c] = 0;
    }

    static ArrayList<String> mazePathBacktracking(boolean[][] maze, String p, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        ArrayList<String> ans = new ArrayList<>();
        if (!maze[r][c]) {
            return ans;
        }
        maze[r][c] = false; // Mark cell as False, and explore the path
        if (r < maze.length - 1) {
            ans.addAll(mazePathBacktracking(maze, p + "D", r + 1, c));
        }
        if (c < maze[0].length - 1) {
            ans.addAll(mazePathBacktracking(maze, p + "R", r, c + 1));
        }
        if (r > 0) {
            ans.addAll(mazePathBacktracking(maze, p + "U", r - 1, c));
        }
        if (c > 0) {
            ans.addAll(mazePathBacktracking(maze, p + "L", r, c - 1));
        }
        // In this line, the function will be over
        maze[r][c] = true; // remark the cell as true, as it was previous
        return ans;
    }

    static ArrayList<String> mazePathObstacle(boolean[][] obs, String p, int r, int c) {
        if (r == obs.length - 1 && c == obs[0].length - 1) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        ArrayList<String> ans = new ArrayList<>();
        if (!obs[r][c]) {
            return ans;
        }
        if (r < obs.length - 1) {
            ans.addAll(mazePathObstacle(obs, p + "D", r + 1, c));
        }
        if (c < obs[0].length - 1) {
            ans.addAll(mazePathObstacle(obs, p + "R", r, c + 1));
        }
        return ans;
    }

    static ArrayList<String> mazePathDaigonal(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        ArrayList<String> ans = new ArrayList<>();
        if (r > 1) {
            ans.addAll(mazePathDaigonal(p + "V", r - 1, c));
        }
        if (c > 1) {
            ans.addAll(mazePathDaigonal(p + "H", r, c - 1));
        }
        if (r > 1 && c > 1) {
            ans.addAll(mazePathDaigonal(p + "D", r - 1, c - 1));
        }
        return ans;
    }

    static ArrayList<String> mazePath(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        ArrayList<String> ans = new ArrayList<>();
        if (r > 1) {
            ans.addAll(mazePath("D" + p, r - 1, c));
        }
        if (c > 1) {
            ans.addAll(mazePath("R" + p, r, c - 1));
        }
        return ans;
    }

    static int mazeCount(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }
        int left = mazeCount(r - 1, c);
        int right = mazeCount(r, c - 1);
        return left + right;
    }
}
