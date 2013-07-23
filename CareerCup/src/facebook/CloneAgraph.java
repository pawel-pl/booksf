package facebook;

/*
 * //definition of the graph
 struct Node
 {
 int data;
 vector<Node*> neighbors;//
 //constructor.....
 };
 Node* DFSCopyGraph(Node* graph,unordered_map<Node*,Node*>& hmap)
 {
 if(hmap.find(graph) != hmap.end())
 return hmap[graph];
 Node* graphCpy = new Node(graph->data);
 hmap[graph] = graphCpy;
 for(int i=0;i<graph->neighbors.size();i++)
 graphCpy->neighbors.push_back(DFSCopyGraph(neighbors[i]),hmap);
 return graphCpy;
 }
 */
public class CloneAgraph {

}
