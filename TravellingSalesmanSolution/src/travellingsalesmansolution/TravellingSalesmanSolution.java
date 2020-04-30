/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travellingsalesmansolution;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author jdb_s
 */
public class TravellingSalesmanSolution {

    static double[] capitalN = {32.3792,58.3019,33.4484,34.7465,38.5816,
                         39.7392,41.7658,39.1582,30.4383,33.7490,
                         21.3069,43.6150,39.7817,39.7684,41.5868,
                        39.0473,38.2009,30.4515,44.3106,38.9784,
                        42.3601,42.7325, 44.9537,32.2988,38.5767,
                        46.5891,40.8136,39.1638,43.2081,40.2206,
                        35.6870,42.6526,35.7796,46.8083,39.9612,
                        35.4676, 44.9429,40.2732,41.8240,34.0007,
                        44.3668,36.1627,30.2672,40.7608,44.2601,
                        37.5407,47.0379,38.3498,43.0731,41.1400};
    
    static double[] capitalW = {86.3077,134.4197,112.0740,92.2896,121.4944,
                         104.9903,72.6734,75.5244,84.2807,84.3880,                
                          157.8583,116.2023,89.6501,86.1581,93.6250,
                        95.6752,84.8733,91.1871,69.7795,76.4922,
                        71.0589,84.5555, 93.0900,90.1848,92.1735,
                        112.0391,96.7026,119.7674,71.5376,74.7597,
                        105.9378,73.7562,78.6382,100.7837,82.9988,
                        97.5164,123.0351,76.8867,71.4128,81.0348,
                        100.3538,86.7816,97.7431,111.8910,72.5754,
                        77.4360,122.9007,81.6326,89.4012,104.8202};
    
    static String[] state =    {"Montgomery, Alabama", "Juneau, Alaska", "Phoenix, Arizona","Little Rock, Arkansas","Sacramento, California",
                         "Denver, Colorado", "Hartford, Connecticut",  "Dover, Delaware","Tallahassee, Florida","Atlanta, Georgia",
                         "Honolulu, Hawaii","Boise, Idaho","Springfield, Illinois","Indianapolis, Indiana","Des Moines, Iowa",
                         "Topeka, Kansas","Frankfort, Kentucky","Baton Rouge, Louisiana","Augusta, Maine","Annapolis, Maryland",
                         "Boston, Massachusetts","Lansing, Michigan","St. Paul, Minnesota","Jackson, Mississippi","Jefferson City, Missouri",
                         "Helena, Montana","Lincoln, Nebraska","Carson City, Nevada","Concord, New Hampshire","Trenton, New Jersey",
                         "Santa Fe, New Mexico","Albany, New York","Raleigh, North Carolina","Bismarck, North Dakota","Columbus, Ohio",
                         "Oklahoma City, Oklahoma","Salem, Oregon","Harrisburg, Pennsylvania","Providence, Rhode Island","Columbia, South Carolina",
                         "Pierre, South Dakota","Nashville, Tennessee","Austin, Texas","Salt Lake City, Utah","Montpelier, Vermont",
                         "Richmond, Virginia","Olympia, Washington","Charleston, West Virginia","Madison, Wisconsin","Cheyenne, Wyoming",};
    
    
    public static void buildGraph(){
        for(int i = 0; i < 50; i++){
            for(int j = 0; j<50; j++){
                
            }
        }
    }
    
    public static int toMiles(double lat1, double long1, double lat2, double long2){
        
        long1 = Math.toRadians(long1); 
        long2 = Math.toRadians(long2); 
        lat1 = Math.toRadians(lat1); 
        lat2 = Math.toRadians(lat2);
        
        double dlon = long2 - long1;  
        double dlat = lat2 - lat1; 
        double a = Math.pow(Math.sin(dlat / 2), 2) 
                 + Math.cos(lat1) * Math.cos(lat2) 
                 * Math.pow(Math.sin(dlon / 2),2); 
              
        double c = 2 * Math.asin(Math.sqrt(a)); 
  
        // Radius of earth in miles 
        double r = 3956; 
  
        // calculate the result 
        int intResult = (int)Math.round(c*r);
        return intResult;
        
    }
    
    public static void findDist(double[] N, double[] W, int[][] points){
        for(int i = 0; i<50; i++){
            for( int j  =0; j <50; j++){
                if(i == j){
                    points[i][j] = 0;
                }
                else{
                    points[i][j] = toMiles(N[i], W[i], N[j], W[j]);
                }
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    { 
        
        //int dist = toMiles(40.2206, 74.7597, 42.6526, 73.7562);
        
        //System.out.println(dist + "Miles");
        
        
        MST t = new MST(); 
        
        int[][] points = new int[50][50];
        
        /*int points[][] = {  { 0, 4, 0, 0, 0, 0, 0, 8, 0},//0  
                            { 4, 0, 8, 0, 0, 0, 0, 11, 0},//1
                            { 0, 8, 0, 7, 0, 4, 0, 0, 2},//2
                            { 0, 0, 7, 0, 9, 14, 0, 0, 0},//3
                            { 0, 0, 0, 9, 0, 10, 0, 0, 0},//4
                            { 0, 0, 4, 14, 10, 0, 2, 0, 0},//5
                            { 0, 0, 0, 0, 0, 2, 0, 1, 6},//6
                            { 8, 11, 0, 0, 0, 0, 1, 0, 7},//7
                            { 0, 0, 2, 0, 0, 0, 6, 7, 0},//8
                        };  */
  
       /* int points[][] = new int[][] { { 0, 10, 15, 20}, 
                                      { 10, 0, 35, 25}, 
                                      { 15, 5, 0, 30}, 
                                      { 20, 25, 30, 0} };
        */
// Print the solution 
        findDist(capitalN, capitalW, points);
        
        Graph g1 = new Graph(50); 

        t.primMST(points, g1);
        
        
        /*g1.addEdge(0, 1);
        g1.addEdge(1, 0);
        g1.addEdge(1, 2); 
        g1.addEdge(2, 1);
        g1.addEdge(1, 4);
        g1.addEdge(4, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 0);
        
        //TestCase2
        g1.addEdge(0, 1);
        g1.addEdge(1, 0);
        g1.addEdge(1, 2);
        g1.addEdge(2, 1);
        g1.addEdge(2, 3);
        g1.addEdge(3, 2);
        g1.addEdge(2, 5);
        g1.addEdge(5, 2);
        g1.addEdge(2, 8);
        g1.addEdge(8, 2);
        g1.addEdge(3, 4);
        g1.addEdge(4, 3);
        g1.addEdge(3, 5);
        g1.addEdge(5, 3);
        g1.addEdge(5, 6);
        g1.addEdge(6, 5);
        g1.addEdge(6, 7);
        g1.addEdge(7, 6);
        g1.addEdge(6, 8);
        g1.addEdge(8, 6);
        g1.addEdge(7, 0);
        g1.addEdge(0, 7);
        g1.addEdge(7, 8);
        g1.addEdge(8, 7);
        g1.addEdge(1, 7);
        g1.addEdge(7, 1);*/
        
        
        //g1.addEdge(3, 4); 
        g1.printEulerTour();
        ArrayList<Integer> arr = g1.returnPath();
        Collections.reverse(arr);
        for(int i:arr){
            System.out.println(state[i]);
        }
        System.out.println(state[0]);
    } 
}
 