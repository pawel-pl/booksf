package vans;

/*
 * http://stackoverflow.com/questions/11401223/grid-walking-game
 */
public class DridWalkinGame {

	/**
	 * int Visit_Component( int (*A)[8], int Visit[8][8], int m,int n , int row, int col)
{

if ( ( row >= m ) || (col >= n )  || (col < 0) || (row < 0)  || A[row][col] == 0         || Visit[row][col] == 1 )
{
    return 0;
}
else
{

    Visit[row][col] = 1;
    int a= 0,b=0,c=0,d=0,result =0;
    a = Visit_Component( A, Visit,m,n, row+1, col);
    b = Visit_Component( A, Visit,m,n, row, col +1);
    c = Visit_Component( A, Visit,m,n, row, col -1);
    d = Visit_Component( A, Visit,m,n, row-1, col );
    Visit[row][col] = 0;
    result  = A[row][col] + max(a,b,c,d);
    return result;
}
}

int main(){

int T;
scanf("%d",&T);
for(int k =0; k<T;k++)
{
    int N ;
    int M;
    int count = 0;
    int maxcount = 0;
    scanf("%d %d",&M,&N);
    int C[8][8];
    int visit[8][8];
    for(int i = 0; i < M; i++)
        for(int j = 0; j < N; j++)
        {
            scanf("%d",&C[i][j]);
            visit[i][j] = 0;
        }
    for( int i= 0 ; i< M ; i++ )
    {
        for( int j =0; j< N ; j++ )
        {

            count  = Visit_Component( C, visit,M,N, i, j);
            if(count > maxcount)
            {
                maxcount  = count;
            }
        }
    }
    printf("%d\n",maxcount);
}
return 0;
}
	 */
}
