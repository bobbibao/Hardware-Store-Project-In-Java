package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Demo application panel to display a range slider.
 */
public class RangeSliderDemo extends JPanel {

    private JLabel rangeSliderLabel1 = new JLabel();
    private JTextField rangeSliderValue1 = BTextField();
    private JLabel rangeSliderLabel2 = new JLabel();
    private JTextField rangeSliderValue2 = BTextField();
    private RangeSlider rangeSlider = new RangeSlider();
    private NumberFormat vndFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
    public RangeSliderDemo(String s1, String s2) {
        setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
        setLayout(new GridBagLayout());
        
        
        rangeSliderLabel1.setText(s1);
        rangeSliderLabel2.setText(s2);
        rangeSliderValue1.setHorizontalAlignment(JLabel.LEFT);
        rangeSliderValue2.setHorizontalAlignment(JLabel.LEFT);
        
        rangeSlider.setPreferredSize(new Dimension(240, rangeSlider.getPreferredSize().height));
        rangeSlider.setMinimum(0);
        rangeSlider.setMaximum(100);
        
        // Add listener to update display.
        rangeSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                RangeSlider slider = (RangeSlider) e.getSource();
                rangeSliderValue1.setText(String.valueOf(slider.getValue()));
                rangeSliderValue2.setText(String.valueOf(slider.getUpperValue()));
            }
        });
        rangeSliderValue1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					display(Integer.parseInt(rangeSliderValue1.getText()), vndFormat.parse(rangeSliderValue2.getText()).intValue());
				} catch (ParseException e1) {
					try {
						display(vndFormat.parse(rangeSliderValue1.getText()).intValue(), vndFormat.parse(rangeSliderValue2.getText()).intValue());
					} catch (ParseException e2) {
						try {
							display(vndFormat.parse(rangeSliderValue1.getText()).intValue(), Integer.parseInt(rangeSliderValue2.getText()));
						} catch (ParseException e3) {
							display(Integer.parseInt(rangeSliderValue1.getText()), Integer.parseInt(rangeSliderValue2.getText()));
							e3.printStackTrace();
						}
						e2.printStackTrace();
					}

				}
			}
        });
        rangeSliderValue2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					display(vndFormat.parse(rangeSliderValue1.getText()).intValue(), Integer.parseInt(rangeSliderValue2.getText()));
				} catch (NumberFormatException | ParseException e1) {
					try {
						display(vndFormat.parse(rangeSliderValue1.getText()).intValue(), vndFormat.parse(rangeSliderValue2.getText()).intValue());
					} catch (NumberFormatException | ParseException e2) {
						try {
							display(Integer.parseInt(rangeSliderValue1.getText()), vndFormat.parse(rangeSliderValue2.getText()).intValue());
						} catch (ParseException e3) {
							display(Integer.parseInt(rangeSliderValue1.getText()), Integer.parseInt(rangeSliderValue2.getText()));
						}
						e2.printStackTrace();
					}
				}
				
			}
        });
        add(rangeSliderLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 3, 3), 0, 0));
        add(rangeSliderValue1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 3, 0), 0, 0));
        add(rangeSliderLabel2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 3, 3), 0, 0));
        add(rangeSliderValue2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 6, 0), 0, 0));
        add(rangeSlider      , new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
            GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    }
    
    public JPanel display(int start, int end) {
        rangeSlider.setValue(start);
        rangeSlider.setUpperValue(end);
        // Initialize value display.
        rangeSliderValue1.setText(String.valueOf(vndFormat.format(rangeSlider.getValue())));
        rangeSliderValue2.setText(String.valueOf(vndFormat.format(rangeSlider.getUpperValue())));
        
        return this;
        }
    public JTextField BTextField() {
		JTextField txt = new JTextField(9);
		txt.setOpaque(false);
        txt.setBackground(new Color(0, 0, 0, 0));
		txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
		return txt;
	}
}
