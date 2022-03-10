package src;

import src.API;

import java.util.*;


public class Main {
    int k;
    private static void log(String text) {
        System.err.println(text);
    }

 public static int  backtrack(int facing){
        if (facing==0){
            API.turnLeft();
            API.turnLeft();
            
            facing = 1; 
           
        }
        else if(facing==1){
            API.turnLeft();
            API.turnLeft();
            facing= 0;
            
        

        }
        else if(facing==2){
            API.turnLeft();
            API.turnLeft();
            facing= 3;
            
        }
        else if(facing==3){
            API.turnLeft();
            API.turnLeft();
            facing= 2;
            
        }
        
        return facing;
 }   
    public static void print2D(int mat[][])
    {
        // Loop through all rows
        for (int[] row : mat)
 
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }
    public static void main(String[] args) {
       Main.log("Running...");
      
        API.setColor(0, 0, 'G');
       API.setText(0, 0, "abc");

        int  [][] initmaze = new int [16][16];
        for(int i = 0 ; i < initmaze.length/2 ; i++){
            for(int j = 0 ; j < initmaze.length/2 ; j++){
               initmaze[i][j] = (initmaze.length-2-i-j);
               initmaze[i][initmaze.length-1-j] = initmaze[i][j];
                initmaze[initmaze.length-1-i][j] = initmaze[i][j];
                initmaze[initmaze.length-1-i][initmaze.length-1-j] = initmaze[i][j];
            }
        }
        
        //Stack <Cord> path = new Stack <Cord> ();
        int facing = 0; // 0 north , 1 south , 2 west , 3 east 
        ArrayList <Cord> s = new ArrayList<Cord>();

        int cols = 0;
        int rows= 15;
        
         while (true) {
            Main.log("rows :"+String.valueOf(rows)+" cols:"+String.valueOf(cols)); 
           Main.log("-----------------"+String.valueOf(facing)+"-----------------");
           Cord tmp = new Cord(rows,cols);
           for (int i= 0; i< s.size(); i++){
                if(s.get(i).x== tmp.x && s.get(i).y == tmp.y ){   
                    facing= backtrack(facing);
                    break;
                }

            }
           s.add(tmp);
           
            //north
            if (facing == 0){
              //  Main.log("Going Up Son ........");
                if (!API.wallLeft()){
                    API.turnLeft();
                    API.moveForward();
                    cols--;
                    facing= 2;
                   
                   // path.push(tmp);                    
                }
              else  if (!API.wallRight()){
                    API.turnRight();
                    API.moveForward();
                    cols++;
                    facing=3;
                }
               else if (!API.wallFront()){
                    API.moveForward();
                    rows--;
                   
                }
            }
               //east
           else   if (facing == 3){
                    if (!API.wallLeft()){
                        API.turnLeft();
                        API.moveForward();
                        rows--;
                       
                        facing=0;
                    }
                  else  if (!API.wallRight()){
                        API.turnRight();
                        API.moveForward();
                        rows++;
                        facing=1;
                    }
                  else if (!API.wallFront()){ 
                        API.moveForward();
                       cols++; 
                    }    
                }
              //south
             else  if (facing == 1){
                
                 
                  if (!API.wallLeft()){
                        API.turnLeft();
                        API.moveForward();
                        cols++;
                        facing=3;
                    }
                  else  if (!API.wallRight()){
                        API.turnRight();
                        API.moveForward();
                        cols--;
                        facing=2;
                    }
                  else if (!API.wallFront()){ 
                        API.moveForward();
                        rows++;
                    }    


                }
               //west
              else  if (facing == 2){
                
                 
                    if (!API.wallLeft()){
                          API.turnLeft();
                          API.moveForward();
                          rows++;
                          facing=1;
                      }
                  else  if (!API.wallRight()){
                          API.turnRight();
                          API.moveForward();
                          facing=0;
                          rows--;
                      }
                    else if (!API.wallFront()){ 
                          API.moveForward();
                          cols--;
                          
                      }    
  
                  }
        
       if (API.wallFront() && API.wallRight() && API.wallLeft()){
           facing= backtrack(facing);
            Main.log("Turnning.......Done");
          //  Main.log("rows :"+String.valueOf(rows)+" cols:"+String.valueOf(cols));
            Main.log("---------------------");
        }
            
    }
  
  
  
  
    }

}
