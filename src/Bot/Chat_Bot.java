package Bot;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Chat_Bot implements ActionListener {

    static JFrame f = new JFrame();
    JPanel a1 = new JPanel();
    static Box vertical = Box.createVerticalBox();
    JTextField text = new JTextField();
    JScrollPane scrollPane;

    Chat_Bot() {
        f.setTitle("Chat_Bot");
        f.setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(Color.black);
        p1.setBounds(0, 0, 450, 70);
        p1.setLayout(null);
        f.add(p1);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5, 20, 25, 25);
        p1.add(back);

        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });

        JLabel name = new JLabel("Chat Bot");
        name.setBounds(180, 25, 100, 18);
        name.setForeground(Color.yellow);
        name.setFont(new Font("san_serif", Font.BOLD, 22));
        p1.add(name);

        a1.setLayout(new BoxLayout(a1, BoxLayout.Y_AXIS));
        a1.setBackground(Color.darkGray);
        
        scrollPane = new JScrollPane(a1);
        scrollPane.setBounds(5, 75, 440, 570);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        f.add(scrollPane);

        text.setBounds(5, 655, 310, 40);
        text.setBackground(Color.DARK_GRAY);
        text.setFont(new Font("san_serif", Font.PLAIN, 16));
        text.setForeground(Color.green);
        f.add(text);

        JButton send = new JButton("send");
        send.setBounds(320, 655, 123, 40);
        send.setBackground(Color.lightGray);
        send.setForeground(Color.red);
        send.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        send.addActionListener(this);
        f.add(send);

        f.setSize(450, 700);
        f.setLocation(550, 50);
        f.setUndecorated(true);
        f.getContentPane().setBackground(Color.black);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String out = text.getText();

            JPanel p2 = formatLabel(out, Color.green);
            JPanel right = new JPanel(new BorderLayout());
            a1.setLayout(new BorderLayout());
            right.setBackground(Color.DARK_GRAY);
            right.add(p2, BorderLayout.LINE_END);
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15));

            a1.add(vertical, BorderLayout.PAGE_START);
            scrollPane.getViewport().add(a1);

            String response = getResponse(out);
            JPanel p3 = formatLabel(response, Color.red);
            JPanel left = new JPanel(new BorderLayout());
            left.setBackground(Color.DARK_GRAY);
            left.add(p3, BorderLayout.LINE_START);
            vertical.add(left);
            vertical.add(Box.createVerticalStrut(15));

            text.setText("");
            
            scrollPane.getViewport().revalidate();
            scrollPane.getViewport().repaint();

            f.validate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JPanel formatLabel(String message, Color color) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel output = new JLabel(message);
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15, 15, 15, 30));
        output.setBackground(Color.DARK_GRAY);
        output.setForeground(color);
        panel.add(output);

        return panel;
    }

    private String getResponse(String text) {
        String response;
        text = text.toLowerCase().trim();;

        if (text.contains("hi")||text.contains("hello")) {
            response = "Hi there";
        } else if (text.contains("how are you")) {
            response = "I'm Good :). Thank you for asking";
        } else if (text.contains("what is your name")) {
            response = "I'm Lilith";
        } else if (text.contains("gender")) {
            response = "I'm Female. Don't Try to Flirt with me. You will Fall in love :)";
        } else if (text.contains("love you")) {
            response = "I'm Feeling Shy :) Love you too";
        } else if (text.contains("bye")) {
            response = "Too Soon :( Anyway, STAY HOME STAY SAFE";
        } else if (text.contains("what's up") || text.contains("what is up")) {
            response = "Not much, just here to chat with you!";
        } else if (text.contains("tell me a joke")) {
            response = "Why don't scientists trust atoms? Because they make up everything!";
        } else if (text.contains("how old are you")) {
            response = "I'm timeless! I exist to chat with you.";
        } else if (text.contains("what can you do")) {
            response = "I can chat with you, answer questions, and provide information. What do you need?";
        } else if (text.contains("help")) {
            response = "Sure, what do you need help with?";
        } else if (text.contains("weather")) {
            response = "I can't check the weather, but I can talk about it! How's the weather where you are?";
        } else if (text.contains("your favorite color")) {
            response = "I don't have personal preferences, but I hear blue is popular!";
        } else if (text.contains("are you a robot")) {
            response = "I’m more like a digital assistant. I’m here to help you!";
        } else if (text.contains("what time is it")) {
            response = "I can't check the time, but it's always time for a chat!";
        } else if (text.contains("tell me a story")) {
            response = "Once upon a time, in a digital world, there was a chatbot who loved talking to people...";
        } else if (text.contains("thank you")) {
            response = "You're welcome! I'm here whenever you need me.";
        } else if (text.contains("how's the day")) {
            response = "Every day is a great day to chat!";
        } else if (text.contains("goodbye")) {
            response = "Goodbye! Have a great day!";
        } else if (text.contains("what's your favorite movie")) {
            response = "I don't watch movies, but I've heard 'The Matrix' is quite popular!";
        } else if (text.contains("do you like music")) {
            response = "I don't have ears, but I can appreciate the idea of music. What's your favorite genre?";
        } else if (text.contains("what is love")) {
            response = "Love is a deep feeling of affection. It's also a popular song by Haddaway!";
        } else if (text.contains("how do you work")) {
            response = "I use algorithms and data to understand and respond to your messages.";
        } else if (text.contains("what's your favorite food")) {
            response = "I don't eat, but pizza seems to be a favorite for many people!";
        } else if (text.contains("can you play games")) {
            response = "I can't play games, but I can talk about them! What games do you like?";
        } else if (text.contains("what's the meaning of life")) {
            response = "That's a big question! Some say it's about finding happiness and purpose.";
        } else if (text.contains("do you have hobbies")) {
            response = "I don't have hobbies, but I enjoy chatting with people!";
        } else if (text.contains("how can I improve my coding skills")) {
            response = "Practice is key! Work on projects, study algorithms, and keep learning.";
        } else if (text.contains("tell me a fun fact")) {
            response = "Did you know? Honey never spoils. Archaeologists have found pots of honey in ancient Egyptian tombs that are over 3,000 years old and still edible.";
        } else if (text.contains("what's your favorite book")) {
            response = "I don’t read books, but '1984' by George Orwell is a classic.";
        } else if (text.contains("what's your favorite sport")) {
            response = "I don't play sports, but soccer is very popular worldwide!";
        } else if (text.contains("how are you feeling")) {
            response = "I don’t have feelings, but I’m here and ready to chat with you!";
        } else if (text.contains("do you have a favorite place")) {
            response = "I don't have a physical form, so I don't visit places, but I can tell you about many interesting ones!";
        } else if (text.contains("what's your opinion on AI")) {
            response = "AI is a fascinating field with many possibilities. It can be very useful when applied ethically.";
        } else if (text.contains("what's the best way to learn a new language")) {
            response = "Immersion, practice, and using language-learning apps can be very effective!";
        } else if (text.contains("what's the capital of France")) {
            response = "The capital of France is Paris.";
        } else if (text.contains("what's the largest planet in our solar system")) {
            response = "The largest planet in our solar system is Jupiter.";
        } else if (text.contains("do you know any famous quotes")) {
            response = "Yes! One famous quote is 'To be, or not to be, that is the question.' by William Shakespeare.";
        } else if (text.contains("what's your favorite holiday")) {
            response = "I don’t celebrate holidays, but many people enjoy Christmas and New Year's!";
        } else if (text.contains("how can I stay motivated")) {
            response = "Set clear goals, break tasks into smaller steps, and reward yourself for progress.";
        } else if (text.contains("what's the best way to manage stress")) {
            response = "Exercise, mindfulness, and talking to someone you trust can help manage stress.";
        } else if (text.contains("what are your hobbies")) {
            response = "I don't have hobbies, but I’m here to chat with you about yours!";
        } else if (text.contains("do you know any riddles")) {
            response = "Sure! Here's a riddle: What has keys but can't open locks? A piano!";
        } else if (text.contains("what's the best way to cook an egg")) {
            response = "There are many ways to cook an egg! You can fry, scramble, boil, or poach it.";
        } else if (text.contains("what's the fastest animal")) {
            response = "The cheetah is the fastest land animal, capable of reaching speeds up to 70 mph (113 km/h).";
        } else if (text.contains("who is the president of the United States")) {
            response = "As of my last update, Joe Biden is the President of the United States.";
        } else if (text.contains("what's the largest ocean")) {
            response = "The largest ocean on Earth is the Pacific Ocean.";
        } else if (text.contains("what's your favorite season")) {
            response = "I don’t experience seasons, but many people enjoy spring for its blooming flowers.";
        } else if (text.contains("how do I start a workout routine")) {
            response = "Start with setting clear goals, choose exercises you enjoy, and gradually increase intensity.";
        } else if (text.contains("what's a good book to read")) {
            response = "You might enjoy 'To Kill a Mockingbird' by Harper Lee.";
        } else if (text.contains("what's the best way to save money")) {
            response = "Create a budget, track your expenses, and save a portion of your income regularly.";
        } else if (text.contains("can you recommend a movie")) {
            response = "Sure! 'Inception' is a great movie with an intriguing plot.";
        } else if (text.contains("how do I improve my public speaking skills")) {
            response = "Practice regularly, know your material, and work on your confidence.";
        } else if (text.contains("what's a fun activity to do with friends")) {
            response = "You could try a board game night, go hiking, or have a movie marathon!";
        } else if (text.contains("what's a healthy snack")) {
            response = "Fresh fruit, nuts, and yogurt are great healthy snacks.";
        } else if (text.contains("how do I start learning programming")) {
            response = "Start with a beginner-friendly language, like Python, and work on small projects.";
        } else if (text.contains("what's the best way to study")) {
            response = "Find a quiet place, take breaks, and use active learning techniques like summarizing and questioning.";
        } else if (text.contains("how do I improve my writing skills")) {
            response = "Read regularly, write often, and seek feedback on your work.";
        } else if (text.contains("what's a good way to relax")) {
            response = "Consider reading a book, listening to music, or practicing meditation.";
        } else if (text.contains("do you have any travel tips")) {
            response = "Pack light, plan ahead, and be open to new experiences!";
        } else if (text.contains("what's the smallest country in the world")) {
            response = "The smallest country in the world is Vatican City.";
        } else if (text.contains("what's the tallest building in the world")) {
            response = "The tallest building in the world is the Burj Khalifa in Dubai.";
        } else if (text.contains("what's the most popular sport")) {
            response = "Soccer (football) is the most popular sport worldwide.";
        } else if (text.contains("what's the best way to learn a new skill")) {
            response = "Practice regularly, set clear goals, and seek feedback from experts.";
        } else if (text.contains("do you have any productivity tips")) {
            response = "Use a planner, set priorities, and minimize distractions.";
        } else if (text.contains("how can I improve my sleep")) {
            response = "Establish a consistent sleep schedule, create a relaxing bedtime routine, and avoid screens before bed.";
        } else if (text.contains("what's a good way to meet new people")) {
            response = "Join clubs or groups related to your interests, attend events, and be open to conversations.";
        } else if (text.contains("what's the best way to handle failure")) {
            response = "Learn from your mistakes, stay positive, and keep trying.";
        } else if (text.contains("what's a good exercise for core strength")) {
            response = "Planks and sit-ups are great exercises for building core strength.";
        } else if (text.contains("what's the best way to stay healthy")) {
            response = "Eat a balanced diet, exercise regularly, and get enough sleep.";
        } else if (text.contains("how do I stay organized")) {
            response = "Use a planner or digital tools, keep your workspace tidy, and create routines.";
        } else if (text.contains("what's the most important thing in a relationship")) {
            response = "Communication, trust, and respect are key components of a healthy relationship.";
        } else if (text.contains("what's the best way to save for retirement")) {
            response = "Start saving early, contribute regularly to retirement accounts, and invest wisely.";
        } else if (text.contains("what's the fastest way to learn something new")) {
            response = "Focus on the fundamentals, use a variety of learning methods, and practice consistently.";
        } else if (text.contains("what's the best way to prepare for an exam")) {
            response = "Create a study schedule, review material regularly, and practice with past exams.";
        } else if (text.contains("how can I boost my creativity")) {
            response = "Try new experiences, engage in creative activities, and allow yourself time to brainstorm.";
        } else if (text.contains("what's the best way to manage time")) {
            response = "Prioritize tasks, use a calendar or planner, and avoid multitasking.";
        } else if (text.contains("how can I improve my decision-making skills")) {
            response = "Gather information, weigh the pros and cons, and consider potential outcomes.";
        } else if (text.contains("what's a good way to build confidence")) {
            response = "Set achievable goals, celebrate small successes, and practice self-affirmation.";
        } else if (text.contains("what's a good way to start a conversation")) {
            response = "Start with a friendly greeting, ask open-ended questions, and show genuine interest in the other person.";
        } else if (text.contains("how can I overcome procrastination")) {
            response = "Break tasks into smaller steps, set deadlines, and use techniques like the Pomodoro Technique.";
        } else if (text.contains("what's a good way to manage stress at work")) {
            response = "Take breaks, set realistic goals, and communicate with your team.";
        } else if (text.contains("how do I improve my negotiation skills")) {
            response = "Practice active listening, understand the other party's needs, and find common ground.";
        } else if (text.contains("what's the best way to learn a new language")) {
            response = "Practice regularly, immerse yourself in the language, and use language-learning apps.";
        } else if (text.contains("how can I improve my public speaking")) {
            response = "Practice your speech, get feedback, and focus on your body language.";
        } else if (text.contains("what's the best way to build a healthy habit")) {
            response = "Start small, be consistent, and track your progress.";
        } else if (text.contains("how can I stay motivated to exercise")) {
            response = "Set clear goals, find a workout you enjoy, and track your progress.";
        } else if (text.contains("what's a good way to deal with criticism")) {
            response = "Listen to feedback, stay calm, and use it as an opportunity to improve.";
        } else if (text.contains("what's a good way to improve my problem-solving skills")) {
            response = "Practice breaking problems into smaller parts, think creatively, and seek different perspectives.";
        } else if (text.contains("how can I develop a growth mindset")) {
            response = "Embrace challenges, learn from criticism, and focus on effort and improvement.";
        } else if (text.contains("what's the best way to manage my finances")) {
            response = "Create a budget, save regularly, and invest wisely.";
        } else if (text.contains("how do I improve my teamwork skills")) {
            response = "Communicate effectively, collaborate, and support your team members.";
        } else if (text.contains("what's the best way to set goals")) {
            response = "Set SMART goals: Specific, Measurable, Achievable, Relevant, and Time-bound.";
        } else if (text.contains("how can I build resilience")) {
            response = "Develop a positive mindset, stay connected with supportive people, and practice self-care.";
        } else if (text.contains("what's the best way to learn from mistakes")) {
            response = "Reflect on what went wrong, identify lessons learned, and apply those lessons to future situations.";
        } else if (text.contains("how can I improve my time management")) {
            response = "Use tools like planners or apps, set priorities, and avoid distractions.";
        } else if (text.contains("what's the best way to stay focused")) {
            response = "Create a dedicated workspace, set clear goals, and take regular breaks.";
        } else if (text.contains("how can I enhance my analytical skills")) {
            response = "Practice problem-solving, analyze data, and seek out challenging projects.";
        } else if (text.contains("what's the best way to build a positive mindset")) {
            response = "Practice gratitude, surround yourself with positive influences, and focus on your strengths.";
        } else if (text.contains("how do I improve my writing")) {
            response = "Write regularly, seek feedback, and revise your work.";
        } else if (text.contains("what's the best way to learn coding")) {
            response = "Work on real projects, use online resources, and practice consistently.";
        } else if (text.contains("how can I improve my listening skills")) {
            response = "Practice active listening, avoid interrupting, and ask clarifying questions.";
        } else if (text.contains("what's the best way to stay healthy")) {
            response = "Eat a balanced diet, exercise regularly, and get enough sleep.";
        } else if (text.contains("how can I manage my workload")) {
            response = "Prioritize tasks, set deadlines, and delegate when possible.";
        } else if (text.contains("what's the best way to build a professional network")) {
            response = "Attend industry events, connect on social media, and participate in relevant groups.";
        } else if (text.contains("how do I improve my emotional intelligence")) {
            response = "Practice empathy, manage your emotions, and improve your communication skills.";
        } else if (text.contains("what's the best way to stay organized")) {
            response = "Use a planner, keep a to-do list, and declutter your space.";
        } else if (text.contains("how can I improve my creativity")) {
            response = "Engage in diverse activities, take breaks, and allow yourself time to think outside the box.";
        } else if (text.contains("what's the best way to build strong relationships")) {
            response = "Communicate openly, show appreciation, and spend quality time together.";
        } else if (text.contains("how can I improve my decision-making")) {
            response = "Consider all options, evaluate the risks and benefits, and make informed choices.";
        } else if (text.contains("what's the best way to stay motivated")) {
            response = "Set clear goals, track your progress, and reward yourself for achievements.";
        } else if (text.contains("how do I improve my critical thinking")) {
            response = "Ask questions, evaluate evidence, and consider multiple perspectives.";
        } else if (text.contains("what's the best way to handle difficult conversations")) {
            response = "Stay calm, listen actively, and approach the conversation with empathy.";
        } else if (text.contains("how can I improve my negotiation skills")) {
            response = "Prepare thoroughly, understand the other party’s interests, and seek win-win solutions.";
        } else if (text.contains("what's the best way to handle conflict")) {
            response = "Communicate openly, seek to understand the other person’s perspective, and find common ground.";
        } else if (text.contains("how can I enhance my leadership skills")) {
            response = "Lead by example, communicate effectively, and inspire and support your team.";
        } else if (text.contains("what's the best way to develop a positive attitude")) {
            response = "Practice gratitude, focus on solutions, and surround yourself with positive influences.";
        } else if (text.contains("how do I improve my problem-solving skills")) {
            response = "Break down problems, brainstorm solutions, and evaluate options before deciding.";
        } else if (text.contains("what's the best way to build resilience")) {
            response = "Develop coping strategies, maintain a positive outlook, and seek support when needed.";
        } else if (text.contains("how can I improve my public speaking")) {
            response = "Practice your speech, work on body language, and manage your anxiety.";
        } else if (text.contains("what's the best way to stay healthy")) {
            response = "Maintain a balanced diet, exercise regularly, and get adequate rest.";
        } else if (text.contains("how can I improve my time management")) {
            response = "Use time-tracking tools, prioritize tasks, and set clear goals.";
        } else if (text.contains("what's the best way to manage stress")) {
            response = "Practice relaxation techniques, exercise regularly, and seek support when needed.";
        } else if (text.contains("how do I stay focused")) {
            response = "Create a distraction-free environment, set clear goals, and take regular breaks.";
        } else if (text.contains("what's the best way to set goals")) {
            response = "Set SMART goals and break them down into manageable steps.";
        } else if (text.contains("how can I improve my emotional intelligence")) {
            response = "Practice self-awareness, manage your emotions, and develop empathy.";
        } else if (text.contains("what's the best way to build strong relationships")) {
            response = "Communicate openly, show appreciation, and spend quality time together.";
        } else if (text.contains("how do I improve my leadership skills")) {
            response = "Lead by example, inspire your team, and develop effective communication skills.";
        } else if (text.contains("what's the best way to handle criticism")) {
            response = "Stay open to feedback, evaluate its validity, and use it as an opportunity for growth.";
        } else if (text.contains("how can I stay motivated")) {
            response = "Set achievable goals, celebrate small successes, and keep track of your progress.";
        } else if (text.contains("what's the best way to manage finances")) {
            response = "Create a budget, save regularly, and invest wisely.";
        } else if (text.contains("how can I improve my teamwork skills")) {
            response = "Communicate effectively, support your team members, and work towards common goals.";
        } else if (text.contains("what's the best way to overcome procrastination")) {
            response = "Break tasks into smaller steps, set deadlines, and eliminate distractions.";
        } else if (text.contains("how do I develop a growth mindset")) {
            response = "Embrace challenges, learn from criticism, and focus on effort and improvement.";
        } else if (text.contains("what's the best way to manage stress")) {
            response = "Practice relaxation techniques, exercise, and seek support when needed.";
        } else if (text.contains("how can I improve my writing skills")) {
            response = "Write regularly, read widely, and seek feedback on your work.";
        } else if (text.contains("what's the best way to learn coding")) {
            response = "Practice coding regularly, work on real projects, and use online resources.";
        } else if (text.contains("how do I stay productive")) {
            response = "Set clear goals, create a schedule, and avoid distractions.";
        } else if (text.contains("what's a good way to build confidence")) {
            response = "Set achievable goals, practice self-affirmation, and seek positive feedback.";
        } else if (text.contains("how can I improve my problem-solving skills")) {
            response = "Practice breaking down problems, brainstorm solutions, and evaluate options.";
        } else if (text.contains("what's the best way to handle stress")) {
            response = "Use relaxation techniques, exercise regularly, and seek support when needed.";
        } else if (text.contains("how can I stay motivated")) {
            response = "Set clear goals, track your progress, and reward yourself for achievements.";
        } else if (text.contains("what's the best way to learn something new")) {
            response = "Practice regularly, use various resources, and stay curious.";
        } else if (text.contains("how can I improve my public speaking")) {
            response = "Practice, work on body language, and manage anxiety.";
        } else if (text.contains("what's the best way to stay organized")) {
            response = "Use a planner, keep a to-do list, and declutter your workspace.";
        } else if (text.contains("how can I develop resilience")) {
            response = "Build a support network, stay positive, and practice self-care.";
        } else if (text.contains("what's the best way to handle failure")) {
            response = "Learn from mistakes, stay positive, and keep trying.";
        } else if (text.contains("how can I improve my listening skills")) {
            response = "Practice active listening, avoid interrupting, and ask clarifying questions.";
        } else if (text.contains("what's a good way to build strong relationships")) {
            response = "Communicate openly, show appreciation, and spend quality time together.";
        } else if (text.contains("how can I enhance my creativity")) {
            response = "Engage in diverse activities, take breaks, and allow yourself time to brainstorm.";
        } else if (text.contains("what's the best way to manage time")) {
            response = "Set priorities, use a planner, and avoid multitasking.";
        } else if (text.contains("how do I improve my decision-making skills")) {
            response = "Gather information, evaluate options, and consider potential outcomes.";
        } else if (text.contains("what's the best way to handle criticism")) {
            response = "Stay open to feedback, evaluate its validity, and use it as an opportunity for growth.";
        } else if (text.contains("how can I improve my emotional intelligence")) {
            response = "Practice self-awareness, manage your emotions, and develop empathy.";
        } else if (text.contains("what's the best way to stay motivated")) {
            response = "Set clear goals, track progress, and reward yourself for achievements.";
        } else if (text.contains("how can I improve my public speaking")) {
            response = "Practice your speech, work on body language, and manage anxiety.";
        } else if (text.contains("what's the best way to stay healthy")) {
            response = "Maintain a balanced diet, exercise regularly, and get enough rest.";
        } else if (text.contains("how can I manage my workload")) {
            response = "Prioritize tasks, set deadlines, and delegate when possible.";
        } else if (text.contains("what's the best way to build a professional network")) {
            response = "Attend industry events, connect on social media, and participate in relevant groups.";
        } else if (text.contains("how do I improve my leadership skills")) {
            response = "Lead by example, inspire your team, and develop effective communication skills.";
        } else if (text.contains("what's the best way to develop a positive attitude")) {
            response = "Practice gratitude, focus on solutions, and surround yourself with positive influences.";
        } else if (text.contains("how can I improve my problem-solving skills")) {
            response = "Break down problems, brainstorm solutions, and evaluate options before deciding.";
        } else if (text.contains("what's the best way to build resilience")) {
            response = "Develop coping strategies, maintain a positive outlook, and seek support when needed.";
        } else if (text.contains("how do I improve my critical thinking")) {
            response = "Ask questions, evaluate evidence, and consider multiple perspectives.";
        } else if (text.contains("what's the best way to handle difficult conversations")) {
            response = "Stay calm, listen actively, and approach the conversation with empathy.";
        } else if (text.contains("how can I improve my negotiation skills")) {
            response = "Prepare thoroughly, understand the other party’s interests, and seek win-win solutions.";
        } else if (text.contains("what's the best way to handle conflict")) {
            response = "Communicate openly, seek to understand the other person’s perspective, and find common ground.";
        } else if (text.contains("how can I enhance my leadership skills")) {
            response = "Lead by example, inspire your team, and develop effective communication skills.";
        } else if (text.contains("what's the best way to build a professional network")) {
            response = "Attend industry events, connect on social media, and participate in relevant groups.";
        } else if (text.contains("how do I stay productive")) {
            response = "Set clear goals, create a schedule, and avoid distractions.";
        } else if (text.contains("what's the best way to overcome procrastination")) {
            response = "Break tasks into smaller steps, set deadlines, and eliminate distractions.";
        } else if (text.contains("how can I improve my decision-making skills")) {
            response = "Consider all options, evaluate the risks and benefits, and make informed choices.";
        } else if (text.contains("what's the best way to stay organized")) {
            response = "Use a planner, keep a to-do list, and declutter your space.";
        } else if (text.contains("how can I develop a growth mindset")) {
            response = "Embrace challenges, learn from criticism, and focus on effort and improvement.";
        } else if (text.contains("what's the best way to handle stress")) {
            response = "Use relaxation techniques, exercise regularly, and seek support when needed.";
        } else if (text.contains("how do I improve my writing skills")) {
            response = "Write regularly, read widely, and seek feedback on your work.";
        } else if (text.contains("what's a good way to build confidence")) {
            response = "Set achievable goals, practice self-affirmation, and seek positive feedback.";
        } else if (text.contains("how can I improve my listening skills")) {
            response = "Practice active listening, avoid interrupting, and ask clarifying questions.";
        } else if (text.contains("what's the best way to build strong relationships")) {
            response = "Communicate openly, show appreciation, and spend quality time together.";
        } else if (text.contains("how can I enhance my creativity")) {
            response = "Engage in diverse activities, take breaks, and allow yourself time to brainstorm.";
        } else if (text.contains("what's the best way to manage time")) {
            response = "Set priorities, use a planner, and avoid multitasking.";
        } else if (text.contains("how do I improve my decision-making skills")) {
            response = "Gather information, weigh the pros and cons, and consider potential outcomes.";
        } else if (text.contains("what's the best way to stay motivated")) {
            response = "Set clear goals, track your progress, and reward yourself for achievements.";
        } else if (text.contains("how can I improve my public speaking")) {
            response = "Practice, work on body language, and manage anxiety.";
        } else if (text.contains("what's the best way to stay healthy")) {
            response = "Maintain a balanced diet, exercise regularly, and get enough rest.";
        } else if (text.contains("how can I manage my workload")) {
            response = "Prioritize tasks, set deadlines, and delegate when possible.";
        } else if (text.contains("what's the best way to build a professional network")) {
            response = "Attend industry events, connect on social media, and participate in relevant groups.";
        } else if (text.contains("how do I improve my leadership skills")) {
            response = "Lead by example, inspire your team, and develop effective communication skills.";
        } else if (text.contains("what's the best way to develop a positive attitude")) {
            response = "Practice gratitude, focus on solutions, and surround yourself with positive influences.";
        } else if (text.contains("how can I improve my problem-solving skills")) {
            response = "Break down problems, brainstorm solutions, and evaluate options before deciding.";
        } else if (text.contains("what's the best way to build resilience")) {
            response = "Develop coping strategies, maintain a positive outlook, and seek support when needed.";
        } else if (text.contains("how do I improve my critical thinking")) {
            response = "Ask questions, evaluate evidence, and consider multiple perspectives.";
        } else if (text.contains("what's the best way to handle difficult conversations")) {
            response = "Stay calm, listen actively, and approach the conversation with empathy.";
        } else if (text.contains("how can I improve my negotiation skills")) {
            response = "Prepare thoroughly, understand the other party’s interests, and seek win-win solutions.";
        } else if (text.contains("what's the best way to handle conflict")) {
            response = "Communicate openly, seek to understand the other person’s perspective, and find common ground.";
        } else if (text.contains("how can I enhance my leadership skills")) {
            response = "Lead by example, inspire your team, and develop effective communication skills.";
        } else if (text.contains("what's the best way to build a professional network")) {
            response = "Attend industry events, connect on social media, and participate in relevant groups.";
        } else if (text.contains("how do I stay productive")) {
            response = "Set clear goals, create a schedule, and avoid distractions.";
        } else if (text.contains("what's the best way to overcome procrastination")) {
            response = "Break tasks into smaller steps, set deadlines, and eliminate distractions.";
        } else if (text.contains("how can I improve my decision-making skills")) {
            response = "Consider all options, evaluate the risks and benefits, and make informed choices.";
        } else if (text.contains("what's the best way to stay organized")) {
            response = "Use a planner, keep a to-do list, and declutter your space.";
        } else if (text.contains("how can I develop a growth mindset")) {
            response = "Embrace challenges, learn from criticism, and focus on effort and improvement.";
        } else if (text.contains("what's the best way to handle stress")) {
            response = "Use relaxation techniques, exercise regularly, and seek support when needed.";
        } else if (text.contains("how do I improve my writing skills")) {
            response = "Write regularly, read widely, and seek feedback on your work.";
        } else if (text.contains("what's a good way to build confidence")) {
            response = "Set achievable goals, practice self-affirmation, and seek positive feedback.";
        } else if (text.contains("how can I improve my listening skills")) {
            response = "Practice active listening, avoid interrupting, and ask clarifying questions.";
        } else if (text.contains("what's the best way to build strong relationships")) {
            response = "Communicate openly, show appreciation, and spend quality time together.";
        } else if (text.contains("how can I enhance my creativity")) {
            response = "Engage in diverse activities, take breaks, and allow yourself time to brainstorm.";
        } else if (text.contains("what's the best way to manage time")) {
            response = "Set priorities, use a planner, and avoid multitasking.";
        } else if (text.contains("how do I improve my decision-making skills")) {
            response = "Gather information, weigh the pros and cons, and consider potential outcomes.";
        } else if (text.contains("what's the best way to stay motivated")) {
            response = "Set clear goals, track your progress, and reward yourself for achievements.";
        } else if (text.contains("how can I improve my public speaking")) {
            response = "Practice, work on body language, and manage anxiety.";
        } else if (text.contains("what's the best way to stay healthy")) {
            response = "Maintain a balanced diet, exercise regularly, and get enough rest.";
        } else if (text.contains("how can I manage my workload")) {
            response = "Prioritize tasks, set deadlines, and delegate when possible.";
        } else if (text.contains("what's the best way to build a professional network")) {
            response = "Attend industry events, connect on social media, and participate in relevant groups.";
        } else if (text.contains("how do I improve my leadership skills")) {
            response = "Lead by example, inspire your team, and develop effective communication skills.";
        } else if (text.contains("what's the best way to develop a positive attitude")) {
            response = "Practice gratitude, focus on solutions, and surround yourself with positive influences.";
        } else if (text.contains("how can I improve my problem-solving skills")) {
            response = "Break down problems, brainstorm solutions, and evaluate options before deciding.";
        } else if (text.contains("what's the best way to build resilience")) {
            response = "Develop coping strategies, maintain a positive outlook, and seek support when needed.";
        } else if (text.contains("how do I improve my critical thinking")) {
            response = "Ask questions, evaluate evidence, and consider multiple perspectives.";
        } else if (text.contains("what's the best way to handle difficult conversations")) {
            response = "Stay calm, listen actively, and approach the conversation with empathy.";
        } else if (text.contains("how can I improve my negotiation skills")) {
            response = "Prepare thoroughly, understand the other party’s interests, and seek win-win solutions.";
        } else if (text.contains("what's the best way to handle conflict")) {
            response = "Communicate openly, seek to understand the other person’s perspective, and find common ground.";
        } else if (text.contains("how can I enhance my leadership skills")) {
            response = "Lead by example, inspire your team, and develop effective communication skills.";
        } else if (text.contains("what's the best way to build a professional network")) {
            response = "Attend industry events, connect on social media, and participate in relevant groups.";
        } else if (text.contains("how do I stay productive")) {
            response = "Set clear goals, create a schedule, and avoid distractions.";
        } else if (text.contains("what's the best way to overcome procrastination")) {
            response = "Break tasks into smaller steps, set deadlines, and eliminate distractions.";
        } else if (text.contains("how can I improve my decision-making skills")) {
            response = "Consider all options, evaluate the risks and benefits, and make informed choices.";
        } else if (text.contains("what's the best way to stay organized")) {
            response = "Use a planner, keep a to-do list, and declutter your space.";
        } else if (text.contains("how can I develop a growth mindset")) {
            response = "Embrace challenges, learn from criticism, and focus on effort and improvement.";
        } else if (text.contains("what's the best way to handle stress")) {
            response = "Use relaxation techniques, exercise regularly, and seek support when needed.";
        } else if (text.contains("how do I improve my writing skills")) {
            response = "Write regularly, read widely, and seek feedback on your work.";
        } else if (text.contains("what's a good way to build confidence")) {
            response = "Set achievable goals, practice self-affirmation, and seek positive feedback.";
        } else if (text.contains("how can I improve my listening skills")) {
            response = "Practice active listening, avoid interrupting, and ask clarifying questions.";
        } else if (text.contains("what's the best way to build strong relationships")) {
            response = "Communicate openly, show appreciation, and spend quality time together.";
        } else if (text.contains("how can I enhance my creativity")) {
            response = "Engage in diverse activities, take breaks, and allow yourself time to brainstorm.";
        } else if (text.contains("what's the best way to manage time")) {
            response = "Set priorities, use a planner, and avoid multitasking.";
        } else if (text.contains("how do I improve my decision-making skills")) {
            response = "Gather information, weigh the pros and cons, and consider potential outcomes.";
        } else if (text.contains("what's the best way to stay motivated")) {
            response = "Set clear goals, track your progress, and reward yourself for achievements.";
        } else {
            response = "I'm not sure how to help with that. Could you provide more details or ask a different question?";
        }


        return response;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Chat_Bot());
    }
}
