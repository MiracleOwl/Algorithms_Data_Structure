public class Greedy_2{
    void sort(int p[], int t[], int n)
    {
        int i,j,tempP,tempT;

        for(i=0;i<n;i++)
        {
            for(j=i+1;j<n;j++)
            {
                if((p[i]/(float)t[i])<(p[j]/(float)t[j]))
                {
                    tempP = p[i];
                    tempT = t[i];
                    p[i] = p[j];
                    t[i] = t[j];
                    p[j] = tempP;
                    t[j] = tempT;
                }
            }
        }
    }
    float grFractKnp(int p[],int t[], float C, int n,float x[])
    {
        sort(p,t,n);
        
        int i;
        float profit = 0;

        for(i=0;i<n;i++)
        {
            x[i] = 0;
        }
        for(i=0;i<n;i++)
        {
            if(C>t[i])
            {
                x[i] = 1;
                C-=t[i];
                profit += p[i];
            }
            else
            {
                x[i] = (C/(float)t[i]);
                profit += x[i]*(float)p[i];
                C=0;
                break;
            }
        }
        return profit;
    }
}