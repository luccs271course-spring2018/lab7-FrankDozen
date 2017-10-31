package edu.luc.cs271.linkedstack;

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;


public class LinkedStack<E> implements IStack<E> {

  /** The topmost node of this stack. The stack gets pushed down from here. */
  private Node<E> top;

  private int size = 0;

  @Override
  public E push(final E obj) {
    // DONE
    top = new Node<>(obj, top);
    size++;
    return obj;
  }

  @Override
  public E peek() {
    // DONE
    if (isEmpty()== true) {
      throw new NoSuchElementException();
    }
    else {
      return top.data;
    }
  }

  @Override
  public E pop() {
    // DONE
    if (isEmpty()== true) {
      throw new NoSuchElementException();
    }
    else {
      E result = top.data;
      top = top.next;
      size--;
      return result;
    }
  }

  @Override
  public boolean isEmpty() {
    // DONE
    if (top == null) {
      return true;
    }
    else {
      return false;
    }
  }

  @Override
  public List<E> asList() {
    final ArrayList<E> result = new ArrayList<>(size);
    populateList(top, result); //
    return result;
  }

  private void populateList(final Node<E> curr, final List<E> result) {
    //
    if (curr == null) {
      return;
    }
    if (curr != null) {
      result.add(curr.data);
    }
    populateList(curr.next, result);
  }
  @Override
  public List<E> asFifoList() {
    final ArrayList<E> result = new ArrayList<>(size);
    populateFifoList(this.top, result); //
    return result;
  }

  private void populateFifoList(final Node<E> curr, final List<E> result) {
    //
    if (curr == null) {
      return;
    }
    if (curr != null) {
      result.add(0, curr.data);
    }

    populateFifoList(curr.next, result);
  }
}