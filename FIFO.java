
import java.util.ArrayList;


public class FIFO {
    public int page_fault;
    public ArrayList<ArrayList<String>> order=new ArrayList<>();

    public static boolean search(String[] array,String character)
    {
        boolean search_result=false;

        for(int i=0;i<array.length;i++)
        {
            if(array[i]==null)
            {

                break;
            }
            if(array[i].equals(character))
            {
                search_result=true;
                break;
            }

        }
        return search_result;
    }


    public int find_page_fault(String[] process,int frame_size)
    {
        String[] frame=new String[frame_size];
        ArrayList<String> order1=new ArrayList<>();

        int j=0;
        for(int i=0;i< process.length;i++) {
            if (!(search(frame, process[i]))) {
                frame[j] = process[i];
                j = (j + 1) % frame.length;
                page_fault = page_fault + 1;



            }
            for (int k = 0; k < frame.length; k++) {
                if(frame[k]!=null)
                { order1.add(frame[k]);}
            }
            order.add(new ArrayList<>(order1));
            order1.clear();






        }

          return page_fault;

    }












}
