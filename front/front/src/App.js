import './App.css';
import Contact from './elements/contact';

function App() {

  const contacts = [
    { id: 1, name: 'John Doe 1', email: 'john@example.com', rate:0 },
    { id: 2, name: 'Jane Doe 2', email: 'jane@example.com', rate:0 },
    { id: 3, name: 'Jane Doe 3' , email: 'jane@example.com', rate:0 },
    { id: 4, name: 'Jane Doe 4', email: 'jane@example.com', rate:0 },
    { id: 5, name: 'Jane Doe 5', email: 'jane@example.com', rate:0 },
    
  ]


  return (
    <div  >
        <ul>
          
          {
            contacts.map((c)=>{
              return <Contact key={c.id} name={ c.name } email={c.email} rate={c.rate}  />
            })
          }
          
        </ul>
    </div>
  );
}

export default App;
