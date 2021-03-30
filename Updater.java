


class Updater {
    
    //State state = new MainMenuState();
    
    void update(int i) {
        StateDemo.state = StateDemo.state.handleUpdate(i);
    }
    
    
}
