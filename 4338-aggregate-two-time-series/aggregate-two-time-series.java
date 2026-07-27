class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {

        List<List<Integer>> list = new  ArrayList<>();
        int i = 0;
        int j = 0;
       

        while (i < series1.length && j < series2.length) {

            if (series1[i][0] < series2[j][0]) {

                int x= series1[i][1]+series2[j][1];
                
                list.add(  Arrays.asList(series1[i][0],x));
                
                i++;

            }

            else if (series1[i][0] >series2[j][0]) {

                int x = series2[j][1]+series1[i][1];
                
                list.add( Arrays.asList(series2[j][0],x));
                j++;

            }


            else { 
                int x =series1[i][1]+series2[j][1];
                list.add(  Arrays.asList(series1[i][0],x));
                i++;
                j++;
                
            }
            
        }


            while(i<series1.length){

                list.add( Arrays.asList(series1[i][0],series1[i][1]));
                i++;
            }

            while(j<series2.length){

                list.add(  Arrays.asList(series2[j][0],series2[j][1]));
                j++;
            }


        return list;

        }

    }
