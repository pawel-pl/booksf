package facebook;

/*
 * Method 1: Sort the array and then do the following (O(n log n)):


p=0,q=n-1;
while(p<q)
{
  if(a[p]+a[q]==k)
  {
      cout<<a[p]<<"\t"<<a[q];
      p++;
      q--;
   }
   else if(a[p]+a[q]>k)
      q--;
   else 
      p++;
}
Method 2: We can use hash table (O(n)):


for(i=0;i<n;i++)
{
   Complement=K-a[i];
   HashTable[a[i]]=i;
   if(SearchHashTable(Complement)!=-1)
     cout<<"Indices:\t"<<HashTable[Complement]<<"\t"<<i<<endl;
}
 */
public class DoesSumExistsInArr {

}
