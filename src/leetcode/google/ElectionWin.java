package leetcode.google;

import java.util.HashMap;
import java.util.Map;

public class ElectionWin {

	public static void main(String[] args) {
		int[][] states = {{5,0,0,20},{4,0,0,19},{2,0,0,10}};
		int electoralsNeeded = (5 + 4 + 2)/2;
		Map<ElectionPair<Integer, Integer>, Integer> dp = new HashMap<>();
		int result = dfs(0, states, electoralsNeeded, dp);
		
		System.out.println(result);
		
		dp.clear();
		
		states = new int[][] {{7,100,200,200},{8,100,300,200},{9,100,400,200}};
		electoralsNeeded = (7 + 8 + 9)/2;
		result = dfs(0, states, electoralsNeeded, dp);
		
		if(result == Integer.MAX_VALUE)
			result = -1;
		System.out.println(result);
	}

	private static int dfs(int id, int[][] states, int electoralsNeeded,
			Map<ElectionPair<Integer, Integer>, Integer> dp) {
		if(id == states.length || electoralsNeeded < 0) {
			return (electoralsNeeded < 0) ? 0 : Integer.MAX_VALUE;
		}
		
		ElectionPair<Integer, Integer> pair = new ElectionPair<>(id, electoralsNeeded);
		if(dp.containsKey(pair)) {
			return dp.get(pair);
		}
		
		int[] state = states[id];
		int electorals = state[0];
		int A = state[1];
		int B = state[2];
		int U = state[3];
		
		int total = A + B + U;
		int voteToWin = (total / 2) + 1;
		
		int min = Integer.MAX_VALUE;
		if(A + U >= voteToWin) {
			int moreVotesNeededToWin = (A >= voteToWin) ? 0 : (voteToWin - A);
			int winState = dfs(id + 1, states, electoralsNeeded - electorals, dp);
			if(winState != Integer.MAX_VALUE) {
				min = Math.min(min, moreVotesNeededToWin + winState);
			}
		}
		
		int looseState = dfs(id + 1, states, electoralsNeeded, dp);
		min = Math.min(min, looseState);
		dp.put(pair, min);	
		return min;	
	}
}

class ElectionPair<K, V> {
	K stateId;
	V electoralNeeded;
	public ElectionPair(K stateId, V electoralNeeded) {
		super();
		this.stateId = stateId;
		this.electoralNeeded = electoralNeeded;
	}
	public K getStateId() {
		return stateId;
	}
	public void setStateId(K stateId) {
		this.stateId = stateId;
	}
	public V getElectoralNeeded() {
		return electoralNeeded;
	}
	public void setElectoralNeeded(V electoralNeeded) {
		this.electoralNeeded = electoralNeeded;
	}
	@Override
	public String toString() {
		return "ElectionPair [stateId=" + stateId + ", electoralNeeded=" + electoralNeeded + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((electoralNeeded == null) ? 0 : electoralNeeded.hashCode());
		result = prime * result + ((stateId == null) ? 0 : stateId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ElectionPair<K, V> other = (ElectionPair<K, V>) obj;
		if (electoralNeeded == null) {
			if (other.electoralNeeded != null)
				return false;
		} else if (!electoralNeeded.equals(other.electoralNeeded))
			return false;
		if (stateId == null) {
			if (other.stateId != null)
				return false;
		} else if (!stateId.equals(other.stateId))
			return false;
		return true;
	}
	
	
}
