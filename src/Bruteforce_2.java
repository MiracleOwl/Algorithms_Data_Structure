// Дадена е шаховска табла. Пресметајте на 
//колку различни начини можат да се постават 
//две “кралици” без да се напаѓаат една со 
//друга. Две “кралици” се напаѓаат ако се 
//наоѓаат во ист ред, колона или дијагонала.


class Bruteforce_2 {
    int daliSeNapagjaat(int i1, int i2, int j1, int j2)
    {
        if(i1==i2)
        {
            return 1;
        }
        if(j1==j2)
        {
            return 1;
        }
        if(Math.abs(i1-i2)==Math.abs(j1-j2))
        {
            return 1;
        }
        return 0;
    }
    int brojNaNachini()
    {
        int i1,i2,j1,j2;
        int rezultat=0;

        for(i1=0;i1<8;i1++)
        {
            for(j1=0;j1<8;j1++)
            {
                for(i2=0;i2<8;i2++)
                {
                    for(j2=0;j2<8;j2++)
                    {
                        if(daliSeNapagjaat(i1, i2, j1, j2)==0)
                        {
                            rezultat++;
                        }
                    }
                }
            }
        }
        return rezultat;
    }
}
