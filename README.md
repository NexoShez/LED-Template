# LED Template
This is code made for testing LEDS on your FRC Robot!

# Wiring your LEDs

Please refer to the WPI documentation when wiring your LEDS, it includes
specific LED types that you can use. This was used with a W2128B LED Strip.

LED Strips (commonly) have two cable extensions, the PWM wires, and the Power wires, naturally the PWM should only take your DATA & SIGNAL wires (commonly green (data) & white (signal)), however the Power wires are 1 red wire and another signal wire, signal in this case is now "negative" and the red is "positive". Please plug them into the VRM (Voltage Regulator Module), and on the 5V-2A Ports. 

Check your wiring with 2 or more people before turning your robot on and your set!

# RGB or HSV?

WPI Documentation is a bit weird but the "Color" variable has a method called "fromHSV", however it converted the H (Hue) into R (Red), S (Saturation), into G (Green), and V (Value) into B (Blue).

Brought to you by FRC Team 2557, The SOTAbots.
Written by Ephraim C.