//Дадени се парички со одредена вредност (постојат парички од 50, 10, 5, 2 и 1 денар), и 
//притоа бројот на парички од секоја вредност е неограничен. За дадена сума да се определи 
//најмалиот број на парички кои се потребни да се формира таа сума

class Greedy_1 {
    void sortCoins (int coins[],int n)
    {
        int i,j,temp;
        for(i=0;i<n;i++)
        {
            for(j=i+1;j<n;i++)
            {
                if(coins[i]<coins[j])
                {
                    temp = coins[i];
                    coins[i] = coins[j];
                    coins[j] = temp;
                }
            }
        }
    }
    int greedyCoins(int coins[], int n, int sum, int coinsNum[])
    {
        sortCoins(coins, n);
        int i=0;
        int br=0;
        while(sum>0)
        {
            coinsNum[i] = sum/coins[i];
            sum -= coinsNum[i] * coins[i];
            br += coinsNum[i];
            i++;
        }
        while(i<n)
        {
            coinsNum[i]=0;
            i++;
        }
        return br;
    }
}
