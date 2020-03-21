#include <iostream>
#include <exception>
#include <SFML/Audio.hpp>
#include <SFML/Graphics.hpp>
#include <SFML/System.hpp>
#include "ball.cpp"
#define LOG std::cerr<<">>> "<<__FILE__<<"["<<__LINE__<<"]:"<<__func__<<"();"<<std::endl;
sf::Event e;

int main() {
	// Open window
	sf::RenderWindow app(sf::VideoMode(800, 600), "SFML window", sf::Style::Titlebar||sf::Style::Close);
	app.setFramerateLimit(60);
	Ball ball1(app, 300, 300, 4, 5);
	Ball ball2(app, 300, 300, 4, 6);
	// Game loop
	while (app.isOpen()) {
		while (app.pollEvent(e)) if(e.type==sf::Event::Closed) app.close();
		// Screen setup
		app.clear();
		ball1.action();
		ball2.action();
		app.display();
	}
	return EXIT_SUCCESS;
}

