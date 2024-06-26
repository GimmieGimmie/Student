# search.py
# ---------
# Licensing Information:  You are free to use or extend these projects for
# educational purposes provided that (1) you do not distribute or publish
# solutions, (2) you retain this notice, and (3) you provide clear
# attribution to UC Berkeley, including a link to http://ai.berkeley.edu.
# 
# Attribution Information: The Pacman AI projects were developed at UC Berkeley.
# The core projects and autograders were primarily created by John DeNero
# (denero@cs.berkeley.edu) and Dan Klein (klein@cs.berkeley.edu).
# Student side autograding was added by Brad Miller, Nick Hay, and
# Pieter Abbeel (pabbeel@cs.berkeley.edu).


"""
In search.py, you will implement generic search algorithms which are called by
Pacman agents (in searchAgents.py).
"""

from sys import call_tracing
import util
from collections import defaultdict

class SearchProblem:
    """
    This class outlines the structure of a search problem, but doesn't implement
    any of the methods (in object-oriented terminology: an abstract class).

    You do not need to change anything in this class, ever.
    """

    def getStartState(self):
        """
        Returns the start state for the search problem.
        """
        util.raiseNotDefined()

    def isGoalState(self, state):
        """
          state: Search state

        Returns True if and only if the state is a valid goal state.
        """
        util.raiseNotDefined()

    def getSuccessors(self, state):
        """
          state: Search state

        For a given state, this should return a list of triples, (successor,
        action, stepCost), where 'successor' is a successor to the current
        state, 'action' is the action required to get there, and 'stepCost' is
        the incremental cost of expanding to that successor.
        """
        util.raiseNotDefined()

    def getCostOfActions(self, actions):
        """
         actions: A list of actions to take

        This method returns the total cost of a particular sequence of actions.
        The sequence must be composed of legal moves.
        """
        util.raiseNotDefined()

class Node():

    def __init__(self, state, path, cost, heuristic, problem):

        self.state = state
        self.path = path
        self.cost = cost
        self.heuristic = heuristic
        self.problem = problem

    def getSuccessors(self, heuristicFunction = None):

        c = []	

        for s in self.problem.getSuccessors(self.state):
            
            state = s[0]
            path = list(self.path)
            path.append(s[1])
            cost = self.cost + s[2]

            if heuristicFunction:
                heuristic = heuristicFunction(state, self.problem)
            else:
                heuristic = 0

            node = Node(state, path, cost, heuristic, self.problem)

            c.append(node)

        return c

def tinyMazeSearch(problem):
    """
    Returns a sequence of moves that solves tinyMaze.  For any other maze, the
    sequence of moves will be incorrect, so only use this for tinyMaze.
    """
    from game import Directions
    s = Directions.SOUTH
    w = Directions.WEST
    return  [s, s, w, s, w, w, s, w]

def depthFirstSearch(problem):
    """
    Search the deepest nodes in the search tree first.

    Your search algorithm needs to return a list of actions that reaches the
    goal. Make sure to implement a graph search algorithm.

    To get started, you might want to try some of these simple commands to
    understand the search problem that is being passed in:

    print("Start:", problem.getStartState())
    print("Is the start a goal?", problem.isGoalState(problem.getStartState()))
    print("Start's successors:", problem.getSuccessors(problem.getStartState()))
    """
    "*** YOUR CODE HERE ***"

    from game import Directions

    fringes = util.Stack()

    s = Node(problem.getStartState(), [], 0, 0, problem)
    fringes.push(s)

    visited = set()

    while 1:

        if fringes.isEmpty():
            return False

        node = fringes.pop()
        curState = node.state

        if problem.isGoalState(curState):
            return node.path

        if curState not in visited:
            visited.add(curState)
            for n in node.getSuccessors():
                fringes.push(n)

    return Directions.NORTH


def breadthFirstSearch(problem):
    """Search the shallowest nodes in the search tree first."""
    "*** YOUR CODE HERE ***"

    from game import Directions

    fringe = util.Queue()

    s = Node(problem.getStartState(), [], 0, 0, problem)
    fringe.push(s)

    visited = set()

    while 1:

        if fringe.isEmpty():
            return False

        node = fringe.pop()
        curState = node.state

        if problem.isGoalState(curState):
            return node.path

        if curState not in visited:
            visited.add(curState)
            for n in node.getSuccessors():
                fringe.push(n)

    return Directions.NORTH

def uniformCostSearch(problem):
    """Search the node of least total cost first."""
    "*** YOUR CODE HERE ***"

    from game import Directions

    fringe = util.PriorityQueue()

    s = Node(problem.getStartState(), [], 0, 0, problem)
    fringe.push(s, s.cost)

    visited = set()

    while 1:

        if fringe.isEmpty():
            return False

        node = fringe.pop()
        curState = node.state

        if problem.isGoalState(curState):
            return node.path

        if curState not in visited:
            visited.add(curState)
            for n in node.getSuccessors():
                fringe.push(n, n.cost)

    return Directions.NORTH

def nullHeuristic(state, problem=None):
    """
    A heuristic function estimates the cost from the current state to the nearest
    goal in the provided SearchProblem.  This heuristic is trivial.
    """
    return 0

def aStarSearch(problem, heuristic=nullHeuristic):
    """Search the node that has the lowest combined cost and heuristic first."""
    "*** YOUR CODE HERE ***"
   
    from game import Directions

    fringe = util.PriorityQueue()

    s = Node(problem.getStartState(), [], 0, 0, problem)
    fringe.push(s, s.heuristic + s.cost)

    visited = set()

    while 1:

        if fringe.isEmpty():
            return False

        node = fringe.pop()
        curState = node.state

        if problem.isGoalState(curState):
            return node.path

        if curState not in visited:
            visited.add(curState)
            for n in node.getSuccessors(heuristic):
                fringe.push(n, n.heuristic + n.cost)

    return Directions.NORTH


# Abbreviations
bfs = breadthFirstSearch
dfs = depthFirstSearch
astar = aStarSearch
ucs = uniformCostSearch
