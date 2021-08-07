import { useEffect, useState } from 'react'
const useDate = () => {
  const [sec, setSec] = useState(0);
  useEffect(() => {
    const interval = setInterval(() => {
      if(sec === 60) {
        setSec(0);
      }
      else { 
        setSec(sec+1);
      }
    }, 5000);
    return () => { clearInterval(interval) };
  })

  return { sec };
};

export default useDate;