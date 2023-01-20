package org.example.model.world;

public enum WorldSide implements IRotatable {
    North{
        public WorldSide rotateLeft(){
            return West;
        }
        public WorldSide rotateRight(){
            return East;
        }
    },East{
        @Override
        public WorldSide rotateLeft(){
            return North;
        }
        @Override
        public WorldSide rotateRight(){
            return South;
        }
    },South{
        @Override
        public WorldSide rotateLeft(){
            return East;
        }
        @Override
        public WorldSide rotateRight(){
            return West;
        }
    },West{
        @Override
        public WorldSide rotateLeft() {
            return South;
        }

        @Override
        public WorldSide rotateRight() {
            return North;
        }
    }
}
