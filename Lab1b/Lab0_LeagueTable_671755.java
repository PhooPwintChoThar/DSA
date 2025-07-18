import java.util.*;

public class Lab0_LeagueTable_671755 {
    
    static int[][] computeTable(List<int[]> matches) {
        int maxTeamId = 7;
        int[][] stats = new int[maxTeamId][5]; // [teamId, MP, GF, GA, Pts]
        
        // Initialize team IDs
        for (int i = 0; i < maxTeamId; i++) {
            stats[i][0] = i + 1;
        }
        
        // Process each match
        for (int[] match : matches) {
            int teamA = match[0];
            int teamB = match[1];
            int goalsA = match[2];
            int goalsB = match[3];
            
            // Update stats for team A (row index is teamA - 1)
            int rowA = teamA - 1;
            stats[rowA][1]++; // matches played
            stats[rowA][2] += goalsA; // goals for
            stats[rowA][3] += goalsB; // goals against
            
            // Update stats for team B (row index is teamB - 1)
            int rowB = teamB - 1;
            stats[rowB][1]++; // matches played
            stats[rowB][2] += goalsB; // goals for
            stats[rowB][3] += goalsA; // goals against
            
            // Award points
            if (goalsA > goalsB) {
                // Team A wins
                stats[rowA][4] += 3;
            } else if (goalsA < goalsB) {
                // Team B wins
                stats[rowB][4] += 3;
            } else {
                // Draw
                stats[rowA][4] += 1;
                stats[rowB][4] += 1;
            }
        }
        
        // Sort the table according to the specified criteria
        Arrays.sort(stats, (a, b) -> {
            // 1. Points (descending)
            int pointsCompare = Integer.compare(b[4], a[4]);
            if (pointsCompare != 0) return pointsCompare;
            
            // 2. Goal difference (descending)
            int goalDiffA = a[2] - a[3];
            int goalDiffB = b[2] - b[3];
            int goalDiffCompare = Integer.compare(goalDiffB, goalDiffA);
            if (goalDiffCompare != 0) return goalDiffCompare;
            
            // 3. Goals scored (descending)
            return Integer.compare(b[2], a[2]);
        });
        
        return stats;
    }
    
    static void demo_1() {
        Map<Integer, String> teamNames = Map.of(
            1, "phy", 2, "chem", 3, "bio",
            4, "math", 5, "stat", 6, "com", 7, "kdai"
        );
        List<int[]> results = Arrays.asList(
            new int[]{1,2,1,2}, new int[]{1,3,2,0}, new int[]{1,4,0,0},
            new int[]{1,5,0,1}, new int[]{1,6,1,2}, new int[]{1,7,2,2},
            new int[]{2,3,3,2}, new int[]{2,4,0,1},
            new int[]{2,5,3,3}, new int[]{2,6,3,0}, new int[]{2,7,2,0},
            new int[]{3,4,1,0},
            new int[]{3,5,1,0}, new int[]{3,6,2,3}, new int[]{3,7,0,0},
            new int[]{4,5,3,1}, new int[]{4,6,0,0}, new int[]{4,7,1,2},
            new int[]{5,6,0,0}, new int[]{5,7,1,0},
            new int[]{6,7,1,0}
        );
        int[][] table = computeTable(results);
        displayTable(table, teamNames);
    }
    
    static void displayTable(int[][] table, Map<Integer,String> teamNames) {
        System.out.println("Team MP GF GA Pts");
        for (int[] row : table) {
            String name = teamNames.getOrDefault(row[0], "Team" + row[0]);
            System.out.printf("%-5s %3d %3d %3d %4d\n",
                name, row[1], row[2], row[3], row[4]);
        }
    }
    
    public static void main(String[] args) {
        demo_1();
    }
}