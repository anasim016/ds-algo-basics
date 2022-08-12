package com.anasim.ztm.masterdsa.ds.trees;

import java.util.List;
import java.util.ArrayList;

public class MyBinarySearchTree {

    private BSTNode rootNode;
    private enum BFSApproach { ITERATIVE, RECURSIVE }
    private enum DFSModes { IN_ORDER, PRE_ORDER, POST_ORDER }

    MyBinarySearchTree() {
        this.rootNode = null;
    }

    public BSTNode insert(Integer value) {
        BSTNode newNode = new BSTNode(value);
        if (this.rootNode == null) {
            this.rootNode = newNode;
        } else {
            BSTNode currentNode = this.rootNode;
            BSTNode tempNode;
            while (currentNode != null) {
                if (value < currentNode.getNodeValue()) {
                    tempNode = currentNode.getLeftNodeRef();
                    if (tempNode == null) {
                        currentNode.setLeftNodeRef(newNode);
                    }
                } else {
                    tempNode = currentNode.getRightNodeRef();
                    if (tempNode == null) {
                        currentNode.setRightNodeRef(newNode);
                    }
                }
                currentNode = tempNode;
            }
        }
        return this.rootNode;
    }

    public boolean lookup(Integer value) {
        if (this.rootNode != null) {
            BSTNode currentNode = this.rootNode;
            while (currentNode != null) {
                if (value.intValue() == currentNode.getNodeValue().intValue()) {
                    return true;
                } else if (value < currentNode.getNodeValue()) {
                    currentNode = currentNode.getLeftNodeRef();
                } else {
                    currentNode = currentNode.getRightNodeRef();
                }
            }
        }
        return false;
    }

    private BSTNode getLeftMostNode(BSTNode root) {
        BSTNode parentNode = root;
        BSTNode currentNode = root.getLeftNodeRef();
        if (currentNode != null) {
            BSTNode leftMostNode = currentNode;
            currentNode = currentNode.getLeftNodeRef();
            while (currentNode != null) {
                leftMostNode = currentNode;
                parentNode = parentNode.getLeftNodeRef();
                currentNode = currentNode.getLeftNodeRef();
            }
            parentNode.setLeftNodeRef(null);
            return leftMostNode;
        }
        return parentNode;
    }

    private BSTNode removeNodeFromLevelNotZero(BSTNode parentNode, BSTNode deleteNode, BSTNode leftSubTree, BSTNode rightSubTree) {
        BSTNode parentLeftChild = parentNode.getLeftNodeRef();
        if (rightSubTree != null) {
            /**
             *  If the node to be deleted have a right child.
             */
            BSTNode leftMostNode = getLeftMostNode(rightSubTree);
            if (parentLeftChild != null && parentLeftChild.equals(deleteNode)) {
                /**
                 *  If the node to be deleted is a left child of the parent node.
                 */
                if (rightSubTree.equals(leftMostNode)) {
                    /**
                     *  If the right child does not have any left child.
                     */
                    parentNode.setLeftNodeRef(leftMostNode);
                    leftMostNode.setLeftNodeRef(leftSubTree);
                } else {
                    /**
                     *  If the right child have a left child.
                     */
                    parentNode.setLeftNodeRef(leftMostNode);
                    leftMostNode.setLeftNodeRef(leftSubTree);
                    leftMostNode.setRightNodeRef(rightSubTree);
                }
            } else {
                /**
                 *  If the node to be deleted is a right child of the parent node.
                 */
                if (rightSubTree.equals(leftMostNode)) {
                    /**
                     *  If the right child does not have any left child.
                     */
                    parentNode.setRightNodeRef(leftMostNode);
                    leftMostNode.setLeftNodeRef(leftSubTree);
                } else {
                    /**
                     *  If the right child have a left child.
                     */
                    parentNode.setRightNodeRef(leftMostNode);
                    leftMostNode.setLeftNodeRef(leftSubTree);
                    leftMostNode.setRightNodeRef(rightSubTree);
                }
            }
            return this.rootNode;
        }
        /**
         *  If the node to be deleted does not have a right child.
         */
        if (parentLeftChild != null && parentLeftChild.equals(deleteNode)) {
            /**
             *  If the node to be deleted is a left child of the parent node.
             */
            parentNode.setLeftNodeRef(leftSubTree);
        } else {
            /**
             *  If the node to be deleted is a right child of the parent node.
             */
            parentNode.setRightNodeRef(leftSubTree);
        }
        return this.rootNode;
    }

    private BSTNode removeRootNode(BSTNode leftSubTree, BSTNode rightSubTree) {
        if (rightSubTree != null) {
            /**
             *  If the rootNode have a right child.
             */
            BSTNode leftMostNode = getLeftMostNode(rightSubTree);
            if (rightSubTree.equals(leftMostNode)) {
                /**
                 *  If the right child does not have any left child.
                 */
                leftMostNode.setLeftNodeRef(leftSubTree);
            } else {
                /**
                 *  If the right child have a left child.
                 */
                leftMostNode.setLeftNodeRef(leftSubTree);
                leftMostNode.setRightNodeRef(rightSubTree);
            }
            this.rootNode = leftMostNode;
            return this.rootNode;
        }
        /**
         *  If the rootNode does not have a right child.
         */
        this.rootNode = leftSubTree;
        return this.rootNode;
    }

    public BSTNode remove(Integer value) {
        if (this.rootNode != null) {
            BSTNode deleteNode = this.rootNode;
            BSTNode parentNode = null;
            while (deleteNode != null) {
                if (value < deleteNode.getNodeValue()) {
                    parentNode = deleteNode;
                    deleteNode = parentNode.getLeftNodeRef();
                } else if (value > deleteNode.getNodeValue()) {
                    parentNode = deleteNode;
                    deleteNode = parentNode.getRightNodeRef();
                } else {
                    BSTNode rightSubTree = deleteNode.getRightNodeRef();
                    BSTNode leftSubTree = deleteNode.getLeftNodeRef();
                    if (parentNode != null) {
                        return removeNodeFromLevelNotZero(parentNode, deleteNode, leftSubTree, rightSubTree);
                    } else {
                        return removeRootNode(leftSubTree, rightSubTree);
                    }
                }
            }
        }
        return null;
    }

    public List<Integer> breadthFirstSearch(BFSApproach mode) {
        switch (mode) {
            case ITERATIVE:
                return breadthFirstSearchIterative();
            case RECURSIVE:
                List<BSTNode> queue = new ArrayList<>();
                queue.add(this.rootNode);
                List<Integer> res = new ArrayList<>();
                return breadthFirstSearchRecursive(queue, res);
            default:
                return null;
        }
    }

    private List<Integer> breadthFirstSearchIterative() {
        BSTNode currentNode;
        BSTNode leftChildNode;
        BSTNode rightChildNode;
        List<Integer> res = new ArrayList<>();
        List<BSTNode> queue = new ArrayList<>();
        queue.add(this.rootNode);
        while (!queue.isEmpty()) {
            currentNode = queue.remove(0);
            res.add(currentNode.getNodeValue());
            leftChildNode = currentNode.getLeftNodeRef();
            rightChildNode = currentNode.getRightNodeRef();
            if (leftChildNode != null) {
                queue.add(leftChildNode);
            }
            if (rightChildNode != null) {
                queue.add(rightChildNode);
            }
        }
        return res;
    }

    private List<Integer> breadthFirstSearchRecursive(List<BSTNode> queue, List<Integer> res) {
        if (queue.isEmpty()) {
            return res;
        }
        BSTNode currentNode = queue.remove(0);
        BSTNode leftChildNode = currentNode.getLeftNodeRef();
        BSTNode rightChildNode = currentNode.getRightNodeRef();
        res.add(currentNode.getNodeValue());
        if (leftChildNode != null) {
            queue.add(leftChildNode);
        }
        if (rightChildNode != null) {
            queue.add(rightChildNode);
        }
        return breadthFirstSearchRecursive(queue, res);
    }

    public List<Integer> depthFirstSearch(DFSModes mode) {
        List<Integer> res = new ArrayList<>();
        switch (mode) {
            case IN_ORDER:
                return depthFirstSearchInOrder(this.rootNode, res);
            case PRE_ORDER:
                return depthFirstSearchPreOrder(this.rootNode, res);
            case POST_ORDER:
                return depthFirstSearchPostOrder(this.rootNode, res);
            default:
                return null;
        }
    }

    private List<Integer> depthFirstSearchInOrder(BSTNode node, List<Integer> res) {
        System.out.println("BaseNode: " + node);
        BSTNode leftChildNode = node.getLeftNodeRef();
        System.out.println("leftChildNode: " + leftChildNode);
        if (leftChildNode != null) {
            depthFirstSearchInOrder(leftChildNode, res);
        }
        Integer nodeVal = node.getNodeValue();
        System.out.println("Adding " + nodeVal + " to the InOrder list");
        res.add(nodeVal);
        BSTNode rightChildNode = node.getRightNodeRef();
        System.out.println("rightChildNode: " + rightChildNode);
        if (rightChildNode != null) {
            depthFirstSearchInOrder(rightChildNode, res);
        }
        return res;
    }

    private List<Integer> depthFirstSearchPreOrder(BSTNode node, List<Integer> res) {
        System.out.println("BaseNode: " + node);
        Integer nodeVal = node.getNodeValue();
        System.out.println("Adding " + nodeVal + " to the PreOrder list");
        res.add(nodeVal);
        BSTNode leftChildNode = node.getLeftNodeRef();
        System.out.println("leftChildNode: " + leftChildNode);
        if (leftChildNode != null) {
            depthFirstSearchPreOrder(leftChildNode, res);
        }
        BSTNode rightChildNode = node.getRightNodeRef();
        System.out.println("rightChildNode: " + rightChildNode);
        if (rightChildNode != null) {
            depthFirstSearchPreOrder(rightChildNode, res);
        }
        return res;
    }

    private List<Integer> depthFirstSearchPostOrder(BSTNode node, List<Integer> res) {
        System.out.println("BaseNode: " + node);
        BSTNode leftChildNode = node.getLeftNodeRef();
        System.out.println("leftChildNode: " + leftChildNode);
        if (leftChildNode != null) {
            depthFirstSearchPostOrder(leftChildNode, res);
        }
        BSTNode rightChildNode = node.getRightNodeRef();
        System.out.println("rightChildNode: " + rightChildNode);
        if (rightChildNode != null) {
            depthFirstSearchPostOrder(rightChildNode, res);
        }
        Integer nodeVal = node.getNodeValue();
        System.out.println("Adding " + nodeVal + " to the PreOrder list");
        res.add(nodeVal);
        return res;
    }

    public static void main(String[] args) {
        MyBinarySearchTree mbst1 = new MyBinarySearchTree();
        System.out.println(mbst1.insert(9));
        System.out.println(mbst1.insert(4));
        System.out.println(mbst1.insert(6));
        System.out.println(mbst1.insert(20));
        System.out.println(mbst1.insert(170));
        System.out.println(mbst1.insert(15));
        System.out.println(mbst1.insert(1));
        System.out.println(mbst1.lookup(15));
        System.out.println(mbst1.lookup(1));
        System.out.println(mbst1.lookup(171));
        System.out.println(mbst1.lookup(20));
        System.out.println(mbst1.insert(17));
        System.out.println(mbst1.insert(13));

        System.out.println("BFS Iterative Approach: " + mbst1.breadthFirstSearch(BFSApproach.ITERATIVE));
        System.out.println("BFS Recursive Approach: " + mbst1.breadthFirstSearch(BFSApproach.RECURSIVE));

        System.out.println("DFS InOrder Mode: " + mbst1.depthFirstSearch(DFSModes.IN_ORDER));
        System.out.println("DFS PreOrder Mode: " + mbst1.depthFirstSearch(DFSModes.PRE_ORDER));
        System.out.println("DFS PostOrder Mode: " + mbst1.depthFirstSearch(DFSModes.POST_ORDER));

        System.out.println(mbst1.remove(9));
        System.out.println(mbst1.remove(4));
        System.out.println(mbst1.remove(1));
        System.out.println(mbst1.remove(17));

        MyBinarySearchTree mbst2 = new MyBinarySearchTree();
        System.out.println(mbst2.remove(69));
        System.out.println(mbst2.insert(69));
        System.out.println(mbst2.remove(69));
    }
}
