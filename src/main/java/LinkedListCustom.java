public class LinkedListCustom {
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public LinkedListCustom insertNode(LinkedListCustom list,int data){
        Node new_node=new Node(data);
        new_node.next=null;
        if(head==null ){
            head=new_node;

        }
        else{
            Node last=head;
            while(last.next!=null)
                last=last.next;
            last.next=new_node;

        }
        return list;
        }
        public void printLinkedlist(LinkedListCustom list){
        Node currNode=list.head;
         while(currNode!=null){
             System.out.println(currNode.data);
             currNode=currNode.next;
         }

        }

    }

