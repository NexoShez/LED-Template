# LED Template
This is code made for testing LEDS on your FRC Robot!

# Wiring your LEDs

Please refer to the WPI documentation when wiring your LEDS, it includes
specific LED types that you can use. This was used with a W2128B LED Strip.

Your LED Strip may have 5 wires on each end.
2 red (Voltage/+), 2 White (Signal/Ground), and 1 Green (Data, its also the black wire on a pwm cord.)

1 of the red and 1 of the white wires go into the 5V-2A ports on your robots [VRM](https://www.andymark.com/products/voltage-regulator-module?gQT=1) (Voltage Regulator Module)

The rest can go into the PWM ports on your RoboRIO.

The extra 1 red wire is useless on the PWM ports, so you can get rid of it or muffle it with some electrical tape (or keep it there).

Check your wiring with 2 or more people before turning your robot on and your set!

# Controls

You only need 1 controller, the left & right bumpers will change the LED set.

Left - Default
Right - Progress Mask

Progress Mask gets controlled with the left joystick (y-axis)

# How to HSV

If you use Googles Color Picker, the Hue is 0-360, however the .fromHSV method puts the hue as 0-180 (so like if i had a hue of 100 , i would have to divide it by 2 before putting it in), (saturation and value are both 0-255 but just treat it like percent) so make sure you put in the right values before you start to get angry at WPI

## You're welcome :3

Brought to you by FRC Team 2557, The SOTAbots.
Written by Ephraim C.