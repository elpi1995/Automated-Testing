package com.cognizant.testing.BlackJack;

public class BlackJack {

		public static void main(String[] args) {
			

		}
		public int play(int dealer, int player){
			if (!(dealer <2|| player<2||dealer>31||player>31)) {
				if(!(dealer>21||player>21)) {
					if(dealer>=player) {
						return dealer;
					}
					else {
						return player;
					}
				}
				else{
					return 0;
				}
			}
			else {
				
				return -1;
			}
		}
	}



