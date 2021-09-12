.DEFAULT_GOAL := create_jar

create_jar:
	$(MAKE) -C src
	mv src/TrumpWillTriumph.jar .
