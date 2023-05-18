
package hrs.utils;

import hrs.components.ImageContainer;
import hrs.models.DiscountItem;
import hrs.models.ReceiptItem;
import hrs.services.ReceiptService;
import hrs.services.TransactionService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ReceiptWindow {
    public static void showReceipt(int transactionId) {
        Thread winThread = new Thread() {
            public void run() {
                
                var transaction = TransactionService.getTransactionById(transactionId);
                var receipt = ReceiptService.getReceiptById(transaction.getReceipt());
                    
                JFrame recWin = new JFrame("E-Receipt: Transaction#" + transactionId);
                recWin.setBackground(Color.WHITE);
                
                JPanel headerContainer = new JPanel();
                    headerContainer.setBackground(Color.WHITE);
                    headerContainer.setLayout(new BoxLayout(headerContainer, BoxLayout.Y_AXIS));
                    
                    ImageContainer logoContainer = new ImageContainer("/logo.jpeg", 100, 100);
                        logoContainer.setBackground(Color.WHITE);
                        logoContainer.setAlignmentX(Component.CENTER_ALIGNMENT);
                    headerContainer.add(logoContainer);
                    
                    {
                        JLabel lblComp = new JLabel("Black Bean Company");
                        lblComp.setBorder(new EmptyBorder(12, 0, 0, 0));
                        lblComp.setFont(new Font("monoscpace", Font.BOLD, 14));
                        lblComp.setAlignmentX(Component.CENTER_ALIGNMENT);
                        headerContainer.add(lblComp);
                    }
                    
                    {
                        JLabel lblComp = new JLabel("Electronic Transaction Receipt");
                        lblComp.setFont(new Font("monoscpace", Font.BOLD, 14));
                        lblComp.setAlignmentX(Component.CENTER_ALIGNMENT);
                        headerContainer.add(lblComp);
                    }
                    
                    {
                        JLabel lblComp = new JLabel("Date: " + DateUtils.format(transaction.getTransactionDate()));
                        lblComp.setFont(new Font("monoscpace", Font.BOLD, 14));
                        lblComp.setAlignmentX(Component.CENTER_ALIGNMENT);
                        headerContainer.add(lblComp);
                    }
                    
                    
                JPanel mainContainer = new JPanel();
                
                    
                    
                    mainContainer.setBorder(new EmptyBorder(12, 12, 12, 12));
                    mainContainer.setBackground(Color.WHITE);
                    mainContainer.setLayout(new GridLayout(3 + receipt.getItems().size() + receipt.getDiscountItems().size(), 2));
                    
                    {
                        JLabel lblComp = new JLabel("Name");
                        lblComp.setFont(new Font("monoscpace", Font.BOLD, 14));
                        lblComp.setAlignmentX(Component.CENTER_ALIGNMENT);
                        mainContainer.add(lblComp);
                    }
                    {
                        JLabel lblComp = new JLabel("Price");
                        lblComp.setFont(new Font("monoscpace", Font.BOLD, 14));
                        lblComp.setAlignmentX(Component.CENTER_ALIGNMENT);
                        lblComp.setHorizontalAlignment(SwingConstants.RIGHT);
                        mainContainer.add(lblComp);
                    }
                    
                    
                    
                    for (ReceiptItem item : receipt.getItems()) {
                        {
                            JLabel lblComp = new JLabel(item.getItemTitle() + " (" + item.getItemQuantity() + ")");
                            lblComp.setFont(new Font("monoscpace", Font.BOLD, 8));
                            mainContainer.add(lblComp);
                            mainContainer.getComponent(mainContainer.getComponentCount()-1).setPreferredSize(new Dimension(200, lblComp.getPreferredSize().height)); 
                        }
                        {
                            JLabel lblComp = new JLabel("P" + (item.getItemPrice() * item.getItemQuantity()));
                            lblComp.setFont(new Font("monoscpace", Font.BOLD, 8));
                            lblComp.setHorizontalAlignment(SwingConstants.RIGHT);
                            mainContainer.add(lblComp);
                        }
                    }
                    
                    double totalAmount = receipt.getTotalPrice();
                    
                    for (DiscountItem item : receipt.getDiscountItems()) {
                        {
                            JLabel lblComp = new JLabel(item.getDiscountTitle());
                            lblComp.setFont(new Font("monoscpace", Font.BOLD, 8));
                            mainContainer.add(lblComp);
                            mainContainer.getComponent(mainContainer.getComponentCount()-1).setPreferredSize(new Dimension(200, lblComp.getPreferredSize().height)); 
                        }
                        
                        {
                            float percentage = ((float) item.getDiscountPercentage()) / 100 ;
                            String str = String.format("%2.02f", percentage * totalAmount);
                            totalAmount += percentage * totalAmount;
                            JLabel lblComp = new JLabel("P" + str);
                            lblComp.setFont(new Font("monoscpace", Font.BOLD, 8));
                            lblComp.setHorizontalAlignment(SwingConstants.RIGHT);
                            mainContainer.add(lblComp);
                        }
                    }
                    
                    {
                        JLabel lblComp = new JLabel("Total");
                        lblComp.setFont(new Font("monoscpace", Font.BOLD, 14));
                        mainContainer.add(lblComp);
                    }
                    {
                        String str = String.format("%2.02f", totalAmount);

                        JLabel lblComp = new JLabel("P" + str);
                        
                        lblComp.setFont(new Font("monoscpace", Font.BOLD, 14));
                        lblComp.setAlignmentX(Component.CENTER_ALIGNMENT);
                        lblComp.setHorizontalAlignment(SwingConstants.RIGHT);
                        mainContainer.add(lblComp);
                    }
                    
                    if (!transaction.isIsFullPaymentMethod()) {
                        {
                            JLabel lblComp = new JLabel("Down Payment (50%)");
                            lblComp.setFont(new Font("monoscpace", Font.BOLD, 14));
                            mainContainer.add(lblComp);
                        }
                        {
                            String str = String.format("%2.02f", totalAmount / 2);

                            JLabel lblComp = new JLabel("P" + str);

                            lblComp.setFont(new Font("monoscpace", Font.BOLD, 14));
                            lblComp.setHorizontalAlignment(SwingConstants.RIGHT);
                            mainContainer.add(lblComp);
                        }
                    } else {
                        {
                            JLabel lblComp = new JLabel("");
                            lblComp.setFont(new Font("monoscpace", Font.BOLD, 14));
                            mainContainer.add(lblComp);
                        }
                        {

                            JLabel lblComp = new JLabel("Fully Paid");

                            lblComp.setFont(new Font("monoscpace", Font.BOLD, 14));
                            lblComp.setHorizontalAlignment(SwingConstants.RIGHT);
                            mainContainer.add(lblComp);
                        }
                    }
                    
                    mainContainer.setPreferredSize(mainContainer.getPreferredSize());
                recWin.add(headerContainer, BorderLayout.NORTH);
                recWin.add(mainContainer, BorderLayout.CENTER);
                
                recWin.setSize(400, 600);
                recWin.setLocationRelativeTo(null);
                recWin.setAlwaysOnTop(true);
                recWin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                recWin.setResizable(false);
                recWin.setVisible(true);
            }
        };
        winThread.start();
    }
}
