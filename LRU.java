import java.util.ArrayList;
import java.util.Hashtable;

import java.util.Set;

public class LRU {
    public  ArrayList<ArrayList<String>> order=new ArrayList<>();
    public String find_least_usage_page(Hashtable<String,Integer> usage)
    {
        Set<String> keys=usage.keySet();
        int first_used=2147483647;
        String least_used="x";
        for(String o:keys)
        {
            if(first_used>usage.get(o))
            {
                first_used=usage.get(o);
            }
        }
        for(String o:keys)
        {
            if(first_used==usage.get(o))
            {
               least_used=o;
               break;
            }
        }
        return least_used;
    }
    public static int find_latest_order(Hashtable<String,Integer> usage)
    {
        Set<String> keys=usage.keySet();
        int latest_used=-5;

        for(String o:keys)
        {
            if(latest_used<usage.get(o))
            {
                latest_used=usage.get(o);
            }
        }

        return latest_used;
    }
    public int find_page_fault(String[] page_stream,int frame_size)
    {
        Hashtable<String,Integer> usage=new Hashtable<>();
        ArrayList<String> order1=new ArrayList<>();
        int page_fault=0;

        int j=0;
        for(int i=0;i< page_stream.length;i++) {

            if((usage.containsKey(page_stream[i])))
            {

                usage.replace(page_stream[i],find_latest_order(usage)+1);



            }


            else if(j<frame_size)
            {

                usage.put(page_stream[i],j);
                order1.add(page_stream[i]);
                page_fault=page_fault+1;
                j=j+1;

            }
            else
            {
                String temp=find_least_usage_page(usage);
                int index=order1.indexOf(temp);
                order1.remove(temp);
                order1.add(index,page_stream[i]);
                usage.remove(temp);
                usage.put(page_stream[i],find_latest_order(usage)+1);
                page_fault=page_fault+1;
            }

            order.add(new ArrayList<>(order1));


        }

        return page_fault;

    }

}
