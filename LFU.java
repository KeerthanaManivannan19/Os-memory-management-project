import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class LFU {
    public int page_fault;
    public  ArrayList<ArrayList<String>> order=new ArrayList<>();
    public  void found_replacement(Hashtable<String,Integer> count,Hashtable<String,Integer> order,String page,int page_order,ArrayList<String> order1)
    {

        Set<String> keys=count.keySet();
        Set<String> keys1=order.keySet();
        ArrayList<String> min_count_pages=new ArrayList<>();
        int min_fre_used=2147483647;
        int min_order=2147483647;
        for(String o:keys)
        {
            if(min_fre_used>count.get(o))
            {
                min_fre_used=count.get(o);
            }
        }


        for(String o:keys)
        {
            if(min_fre_used==count.get(o))
            {
                min_count_pages.add(o);
            }
        }


        for(String o:min_count_pages)
        {
            if(order.get(o)<min_order)
            {
                min_order=order.get(o);
            }
        }

        for(String o:keys1)
        {
            int temp=order.get(o);

            if(temp==min_order)
            {
                count.remove(o);
                order.remove(o);
                int index=order1.indexOf(o);
                order1.remove(o);
                order1.add(index,page);
                count.put(page,1);
                order.put(page,page_order);

                break;
            }
        }





    }
    public  int find_page_fault(String[] process,int frame_size)
    {
        ArrayList<String> order1=new ArrayList<>();
        Hashtable<String,Integer> tracking_page_count=new Hashtable<>();
        Hashtable<String,Integer> tracking_page_order=new Hashtable<>();


        int j=0;
        for(int i=0;i< process.length;i++) {

            if((tracking_page_count.containsKey(process[i])))
            {
                tracking_page_count.replace(process[i],tracking_page_count.get(process[i])+1);




            }


            else if(j<frame_size)
            {
                tracking_page_count.put(process[i],1 );
                tracking_page_order.put(process[i],i);
                page_fault=page_fault+1;
                j=j+1;
                order1.add(process[i]);

            }
            else
            {
                found_replacement(tracking_page_count,tracking_page_order,process[i],page_fault,order1);
                page_fault=page_fault+1;
            }
            order.add(new ArrayList<>(order1));

        }


            return page_fault;


    }

}
