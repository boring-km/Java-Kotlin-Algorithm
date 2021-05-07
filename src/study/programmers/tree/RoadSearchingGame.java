package study.programmers.tree;

import java.util.ArrayList;
import java.util.Collections;

public class RoadSearchingGame {
    public static void main(String[] args) {
        int[][] result = solution(
                new int[][]{
                        {5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}
                }
        );
        for (int[] res : result) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(res[j] + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<Node> nodeList = new ArrayList<>();
    private static int index = 0;

    public static int[][] solution(int[][] nodeinfo) {
        // 노드의 갯수
        int n = nodeinfo.length;

        // node 생성
        for(int i = 0; i < n; i++) {
            nodeList.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        // y 기준 내림차순 정렬
        Collections.sort(nodeList);

        // 루트 노드 - 가장 y 값이 높은 하나의 루트
        Node root = nodeList.get(0);

        // 노드 연결
        for(int i = 1; i < n; i++) {
            Node child = nodeList.get(i);
            connectNode(root, child);
        }

        int[][] answer = new int[2][n];

        // 전위 순회
        preOrder(answer, root);
        index = 0;
        // 후위 순회
        postOrder(answer, root);

        return answer;
    }

    // 노드 연결
    private static void connectNode(Node parent, Node child) {
        if(child.x < parent.x) {    // 왼쪽 서브 트리
            if(parent.left == null) {
                parent.left = child;
            } else {    // 왼쪽 노드에 이미 노드가 있다면 그 노드의 서브노드로 탐색
                connectNode(parent.left, child);
            }
        } else {    // 오른쪽 서브 트리
            if(parent.right == null) {
                parent.right = child;
            } else {
                connectNode(parent.right, child);
            }
        }
    }

    // 전위 순회
    private static void preOrder(int[][] arr, Node node) {
        if(node != null) {
            arr[0][index++] = node.data;
            if(node.left != null) preOrder(arr, node.left);
            if(node.right != null) preOrder(arr, node.right);
        }
    }

    // 후위 순회
    private static void postOrder(int[][] arr, Node node) {
        if(node != null) {
            if(node.left != null) postOrder(arr, node.left);
            if(node.right != null) postOrder(arr, node.right);
            arr[1][index++] = node.data;
        }
    }
}

class Node implements Comparable<Node>{
    int data;
    int x;
    int y;
    Node left;
    Node right;


    Node(int data, int x, int y){
        this.data = data;
        this.x = x;
        this.y = y;
    }

    // 정렬할 때 비교할 값을 y로 내림차순
    @Override
    public int compareTo(Node node) {
        return node.y - this.y;
    }
}