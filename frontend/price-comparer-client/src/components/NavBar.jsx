import Link from "next/link";

export default function NavBar() {
  return (
    <nav>
      <ul className="my-8 flex gap-2">
        <li>
          <Link href="/" className="px-6 py-1 uppercase font-semibold tracking-wider border-2 text-green-400 hover:underline">           Home
          </Link>
        </li>
        <li>
          <Link href="/submit" className="px-6 py-1 uppercase font-semibold tracking-wider border-2 text-green-400 hover:underline">
            Submit
          </Link>
        </li>
      </ul>
    </nav>
  );
}
